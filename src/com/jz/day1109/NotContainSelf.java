package com.jz.day1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NotContainSelf {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int P = Integer.parseInt(line[1]);
        int[] arr = new int[N];
        String[] line2 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line2[i]);
        }
//        int[] res = multisum(N, P, arr);
        long[] res = multisum2(N, P, arr);
        for (int i = 0; i < res.length - 1; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.print(res[res.length - 1]);
    }

    /**
     * 不使用除法的解法
     * 1. 生成两个长度和arr一样的新数组lr[]和rl[]，lr[]表示从左到右的累乘，rl[]表示从右向左的累乘
     * 2. 一个位置上除去自己值的累乘，就是自己左边的累乘再乘以自己右边的累乘，即res[i] = lr[i-1]*rl[i+1]
     * 3. 最左的位置和最右的位置的累乘比较特殊，即res[0] = rl[1]，res[n-1] = lr[n-2]
     * @param n
     * @param p
     * @param arr
     * @return
     */
    private static long[] multisum2(int n, int p, int[] arr) {
        if (arr == null || n < 2) {
            return null;
        }
        long[] res = new long[n];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = res[i - 1] * arr[i] % p;
        }
        long temp = 1;
        for (int i = arr.length - 1; i > 0; i--) {
            res[i] = res[i - 1] * temp % p;
            temp = temp * arr[i] % p;
        }
        res[0] = temp;
        return res;
    }

    // 使用除法解决
    private static int[] multisum(int n, int p, int[] arr) {
        if (n == 0) {
            return null;
        }
        int count = 0; //统计数组中是0的元素
        int all = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                all *= arr[i] % p;
            } else {
                count++;
            }
        }
        int[] res = new int[arr.length];
        if (count == 0) { // 如果不存在0元素
            for (int i = 0; i < arr.length; i++) {
                res[i] = all / arr[i] % p;
            }
        }
        if (count == 1) { //如果只有1个0元素
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    res[i] = all;
                }
            }
        }
        return res; // 如果有多个0元素，则res中的所有位置都是0
    }

}
