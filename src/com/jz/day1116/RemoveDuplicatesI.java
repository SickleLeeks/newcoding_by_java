package com.jz.day1116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Leetcode: 26 删除有序数组中的重复项
 */
public class RemoveDuplicatesI {
    /**
     * 双指针法
     *
     * @param nums
     * @return
     */
    public static int removeDuplicatesI(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(",");
        int[] nums = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        int res = removeDuplicatesI(nums);
        System.out.println(res);
    }
}
