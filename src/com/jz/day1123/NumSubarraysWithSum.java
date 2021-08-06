package com.jz.day1123;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Leetcode 930 和相同的二元子数字 常考题
 */
public class NumSubarraysWithSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] strs = sc.nextLine().split(",");
            int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
            int goal = Integer.parseInt(sc.nextLine());
            int res = numSubarraysWithSum(nums, goal);
            System.out.println(res);
        }
        sc.close();
    }

    /**
     * 哈希表 : 前缀和
     *
     * @param nums
     * @param goal
     * @return
     */
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int ret = 0;
        for (int num : nums) {
            count.put(sum, count.getOrDefault(sum, 0) + 1);
            sum += num;
            ret += count.getOrDefault(sum - goal, 0);
        }
        return ret;
    }

    /**
     * 滑动窗口
     *
     * @param nums
     * @param goal
     * @return
     */
    public static int numSubarraysWithSum2(int[] nums, int goal) {
        int n = nums.length;
        int left1 = 0, left2 = 0, right = 0;
        int sum1 = 0, sum2 = 0;
        int res = 0;
        while (right < n) {
            sum1 += nums[right];
            while (left1 <= right && sum1 > goal) {
                sum1 -= nums[left1];
                left1++;
            }
            sum2 += nums[right];
            while (left2 <= right && sum2 >= goal) {
                sum2 -= nums[left2];
                left2++;
            }
            res += left2 - left1;
            right++;
        }
        return res;

    }

}
