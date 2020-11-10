package com.company.day1017;

public class FindGreatestSumOfSubArray_Solution {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int sum = Integer.MIN_VALUE;
        int[][] dp = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (i == j) {
                    dp[i][j] = array[i];
                } else {
                    dp[i][j] = array[j] + dp[i][j - 1];
                }
                sum = Math.max(sum, dp[i][j]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, -8, -1, -5, -9};
        int res = FindGreatestSumOfSubArray(arr);
        System.out.println(res);
    }
}
