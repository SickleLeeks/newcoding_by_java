package com.jz.day1115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 不相邻最大
 */
public class Subsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(",");
        int[] array = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        int n = array.length;
        long res = subsequence(n, array);
        System.out.println(res);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算
     * 打家劫舍问题：
     * 状态转移表达式：
     * (1)对于当前的元素arr[i],如果偷，那么dp[i] = dp[i-2] + arr[i]
     * (2)如果不偷，那么dp[i] = dp[i-1]
     *
     * @param n     int整型 数组的长度
     * @param array int整型一维数组 长度为n的数组
     * @return long长整型
     */
    public static long subsequence(int n, int[] array) {
        // write code here
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = array[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + array[i - 1]);
        }
        return dp[n];
    }
}
