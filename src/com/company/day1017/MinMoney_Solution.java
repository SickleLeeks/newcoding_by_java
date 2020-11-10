package com.company.day1017;

public class MinMoney_Solution {
    /**
     * 最少货币数
     *
     * @param arr int整型一维数组 the array
     * @param aim int整型 the target
     * @return int整型
     */
    public static int minMoney(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < aim + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < aim + 1; i++) {
            dp[0][i] = (i % arr[0] == 0) ? (i / arr[0]) : Integer.MAX_VALUE;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < aim + 1; j++) {
                int tmp = Integer.MAX_VALUE;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != Integer.MAX_VALUE) {
                    tmp = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(tmp, dp[i - 1][j]);
            }
        }
        return dp[arr.length - 1][aim] != Integer.MAX_VALUE ? dp[arr.length - 1][aim] : -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 3};
        int aim = 20;
        System.out.println(minMoney(arr, aim));
    }
}
