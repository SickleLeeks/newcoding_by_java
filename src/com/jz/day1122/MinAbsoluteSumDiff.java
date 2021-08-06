package com.jz.day1122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Leetcode1818. 绝对差值和
 */
public class MinAbsoluteSumDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] nums1 = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int[] nums2 = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int res = minAbsoluteSumDiff(nums1, nums2);
            System.out.println(res);
        }
        sc.close();
    }

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int n = nums1.length;
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        long sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int a = nums1[i], b = nums2[i];
            if (a == b) continue;
            int diff = Math.abs(a - b);
            sum += diff;
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = left + right + 1 >> 1;
                if (sorted[mid] <= b) left = mid;
                else right = mid - 1;
            }
            //寻找最接近b的元素，当前位置和下一个位置都检查一下，差值越小，说明越接近
            int newDiff = Math.abs(sorted[right] - b);
            if (right + 1 < n) newDiff = Math.min(newDiff, Math.abs(sorted[right + 1] - b));
            // 使用diff-newDiff，得到的是最大可削减的差值
            if (newDiff < diff) max = Math.max(max, diff - newDiff);
        }
        return (int) ((sum - max) % MOD);
    }
}
