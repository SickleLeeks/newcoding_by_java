package com.jz.day1125;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * 1877. 数组中最大数对和的最小值
 */
public class MinPairSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(minPairSum(nums));
    }

    // 对原数组 nums 进行排序，然后从一头一尾开始往中间组「数对」，取所有数对中的最大值即是答案
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[n - 1];
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            ans = Math.max(ans, nums[i] + nums[j]);
        }
        return ans;
    }
}
