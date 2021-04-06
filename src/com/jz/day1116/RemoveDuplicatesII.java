package com.jz.day1116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Leetcode 80:删除有序数组中的重复项II
 */
public class RemoveDuplicatesII {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(",");
        int[] nums = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        int res = removeDuplicatesII(nums);
        System.out.println(res);
    }

    /**
     * 双指针法
     * @param nums
     * @return
     */
    public static int removeDuplicatesII(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
