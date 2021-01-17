package com.jz.day1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 换钱的方法数
 */
public class ExchangeMoney {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        int aim = Integer.parseInt(str1[1]);
        String[] str2 = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str2[i]);
        }
//        int ways = countExchangeMoney(n, aim, arr);
//        int ways = countExchangeMoney2(n, aim, arr);// 动态规划
//        int ways = countExchangeMoney3(n, aim, arr);// 动态规划优化
        int ways = countExchangeMoney4(n, aim, arr);
        System.out.println(ways);
    }

    private static int countExchangeMoney4(int n, int aim, int[] arr) {
        if (arr == null || n == 0 || aim < 0) {
            return 0;
        }
        int[] dp = new int[aim + 1];
        for (int i = 0; arr[0] * i <= aim; i++) {
            dp[arr[0] * i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
            }
        }
        return dp[aim];
    }

    private static int countExchangeMoney3(int n, int aim, int[] arr) {
        if (arr == null || n == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[n][aim + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; arr[0] * i <= aim; i++) {
            dp[0][arr[0] * i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }

    private static int countExchangeMoney2(int n, int aim, int[] arr) {
        if (arr == null || n == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[n][aim + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; arr[0] * i <= aim; i++) {
            dp[0][arr[0] * i] = 1;
        }
        int num = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[n - 1][aim];
    }

    private static int countExchangeMoney(int n, int m, int[] arr) {
        if (arr == null || n == 0 || m < 0) {
            return 0;
        }
        //return process1(arr, 0, m); // 暴力递归法
        // 记忆化搜索
        int[][] map = new int[arr.length + 1][m + 1];
        return process2(arr, 0, m, map);
    }

    private static int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; arr[index] * i <= aim; i++) {
                mapValue = map[index + 1][aim - arr[index] * i];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }

    private static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }
}
