package com.nc.day1010;

import java.util.Arrays;

/**
 * 最长递增子序列
 */
public class MaxAscSequence_Solution {
    /**
     * retrun the longest increasing subsequence
     * 动态规划 O(n^2)
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public static int[] LIS(int[] arr) {
        int N = arr.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        for (int i = 0; i < arr.length; i++) {
            // 找出arr[i]前面那些结尾比arr[i]小的子序列，将arr[i]接到最后，形成一个递增子序列，即长度加1
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    // 找出arr[i]之前最长的递增子序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int len = 0;
        for (int i = 0; i < dp.length; i++) {
            len = Math.max(len, dp[i]);
        }
        int[] res = new int[len];
        // 逆序，数组中最长递增子序列是升序，其中遍历过程中每个递增阶段最先出现的一定是最小的
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == len) {
                res[--len] = arr[i];
            }
        }
        return res;
    }

    /**
     * retrun the longest increasing subsequence
     * 贪心策略
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public static int[] LIS_2(int[] arr) {
        int[] dp = new int[arr.length]; // 存储每个元素的最大子序列个数
        int[] endSet = new int[arr.length + 1]; //列表的最大子序列，下标从1开始
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if (endSet[len] < arr[i]) {
                // 当arr[i]>end[len]时，arr[i]添加在end后面
                len += 1;
                endSet[len] = arr[i];
                dp[i] = len;
            } else {
                // 当前元素小于end中最后一个元素，利用二分法寻找第一个大于arr[i]的元素
                // end[l] 替换为当前元素
                int left = 0, right = len;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (endSet[mid] >= arr[i]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                endSet[left] = arr[i];
                dp[i] = left;
            }
        }
        int[] res = new int[len];
        // 逆序，数组中最长递增子序列是升序，其中遍历过程中每个递增阶段最先出现的一定是最小的
        for (int i = arr.length - 1; i >= 0; i--) {
            if (dp[i] == len) {
                res[--len] = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] res = LIS_2(arr);
        System.out.println(Arrays.toString(res));
    }
}
