package com.jz.day1122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Leetcode1846. 减小和重新排列数组后的最大元素
 */
public class MaximumElementAfterDecrementingAndRearranging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] arr = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int res = maximumElementAfterDecrementingAndRearranging(arr);
            System.out.println(res);
        }
        sc.close();
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int maxValue = 1;
        if (arr[0] != 1) {
            arr[0] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = arr[i - 1] + 1;
            }
            maxValue = Math.max(maxValue, arr[i]);
        }
        return maxValue;
    }

    public static int maximumElementAfterDecrementingAndRearranging2(int[] arr) {
        int n = arr.length;
        int[] cnt = new int[n + 1];
        for (int v : arr) {
            ++cnt[Math.min(v, n)];
        }
        int miss = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 0) {
                ++miss;
            } else {
                // miss 不会小于 0，故至多减去 miss 个元素
                miss -= Math.min(cnt[i] - 1, miss);
            }
        }
        return n - miss;
    }
}
