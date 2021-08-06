package com.jz.day1123;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 面试题17.10主要元素
 */
public class MajorityElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            System.out.println(majorityElement(nums));
        }
        sc.close();
    }

    /**
     * Boyer-Moore 投票算法
     * 在 Boyer-Moore 投票算法中，遇到相同的数则将 count 加 1，遇到不同的数则将 count 减 1
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        int len = nums.length;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count * 2 > len ? candidate : -1;
    }
}
