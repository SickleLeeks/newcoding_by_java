package com.nc.day1012;

/**
 * 子数组的最大累加和
 */
public class TwoArrayMaxSum {
    /**
     * max sum of the subarray
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int maxsumofSubarray(int[] arr) {
        // write code here
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                dp[j] = dp[j - 1] + arr[j];
                if (dp[j] > max) {
                    max = dp[j];
                }
            }
        }
        return max;
    }

    public static int maxsumofSubarray2(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max + arr[i] > arr[i]) {
                max = max + arr[i];
            } else {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, 5, -2, 6, -1};
        int res = maxsumofSubarray2(arr);
        System.out.println(res);
    }
}
