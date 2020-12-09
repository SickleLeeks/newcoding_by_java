package com.jz.day1109;

import java.math.BigInteger;
import java.util.Scanner;

public class Fibonacci {
    /**
     * Fibonacci数列
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("请输入要计算的数字：");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 读取输入数据
            int n = sc.nextInt();
            // 判断是否为正整数，如果是则isPositive为true, 否则为false
            boolean isPositive = n > 0;
            BigInteger result_1 = fib_1(n, isPositive); // 使用递归的方法
            BigInteger result_2 = fib_2(n, isPositive); // 使用动态规划的方法
            System.out.println("使用递归计算得到的结果为：" + result_1);
            System.out.println("使用动态规划计算得到的结果为：" + result_2);
        }
        sc.close();
    }

    /**
     * 使用递归的方法
     *
     * @param n           要计算的数字
     * @param isPositive： 是否是正数，如果是，则为true, 否则为false
     * @return
     */
    private static BigInteger fib_1(int n, boolean isPositive) {
        if (n == 0) {
            return BigInteger.valueOf(0);
        } else if (n == 1 || n == -1) {
            return BigInteger.valueOf(1);
        } else if (isPositive) {
            return fib_1(n - 2, isPositive).add(fib_1(n - 1, isPositive));
        } else {
            return fib_1(n + 2, isPositive).subtract(fib_1(n + 1, isPositive));
        }
    }

    /**
     * 使用动态规划的方法
     *
     * @param n:                要计算的数字
     * @param isPositive：是否为正整数
     * @return
     */
    private static BigInteger fib_2(int n, boolean isPositive) {
        if (n == 0) {
            return BigInteger.valueOf(0);
        }
        if (n == 1 || n == -1) {
            return BigInteger.valueOf(1);
        }
        // 使用Math的abs函数，计算n的绝对值，将其作为构建动态规划数组的大小
        int size = Math.abs(n);
        // 创建动态规划数组,记录每个阶段的数值
        BigInteger[] dp = new BigInteger[size + 1];
        dp[0] = BigInteger.valueOf(0);// 第一个位置为0
        dp[1] = BigInteger.valueOf(1);// 第二个位置为1
        for (int i = 2; i <= size; i++) {
            if (isPositive) {
                dp[i] = dp[i - 2].add(dp[i - 1]);
            } else {
                dp[i] = dp[i - 2].subtract(dp[i - 1]);
            }
        }
        return dp[size];
    }
}
