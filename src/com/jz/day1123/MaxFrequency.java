package com.jz.day1123;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Leetcode 1838. 最高频元素的频数
 */
public class MaxFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int k = Integer.parseInt(sc.nextLine());
            int res = maxFrequency(nums, k);
            System.out.println(res);
        }
        sc.close();
    }

    /**
     * 滑动窗口法
     * @param nums
     * @param k
     * @return
     */
    public static int maxFrequency(int[] nums, int k) {
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int left = 0, res = 1;
        for (int right = 1; right < n; right++) {
            total += (long) (nums[right] - nums[right - 1]) * (right - left);
            while (total > k) {
                total -= nums[right] - nums[left];
                ++left;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
