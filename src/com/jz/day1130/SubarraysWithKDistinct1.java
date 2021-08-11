package com.jz.day1130;

import java.util.Arrays;
import java.util.Scanner;

public class SubarraysWithKDistinct1 {
    public static int[] count;
    public static int size;

    private static int subarraysWithKistinct(int[] nums, int target) {
        return subArraysWithMostKDistinct(nums, target) - subArraysWithMostKDistinct(nums, target - 1);
    }

    private static int subArraysWithMostKDistinct(int[] nums, int k) {
        count = new int[nums.length + 1]; // 数组是闭区间，所以长度+1
        size = 0;
        int result = 0;
        int left = 0, right = 0;
        while (left < nums.length) {
            while (right < nums.length && size <= k && (size != k || count[nums[right]] != 0)) {
                add(nums[right++]);
            }
            result += (right - left);
            delete(nums[left++]);
        }
        return result;
    }

    private static void delete(int num) {
        if (count[num] == 1) size--;
        count[num]--;
    }

    private static void add(int num) {
        if (count[num] == 0) size++;
        count[num]++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());
            System.out.println(subarraysWithKistinct(nums, target));
            System.out.println(subarraysWithKistinct2(nums, target));
        }
        sc.close();
    }

    private static int subarraysWithKistinct2(int[] nums, int target) {
        return getMaxK(nums, target) - getMaxK(nums, target - 1);
    }

    private static int getMaxK(int[] A, int k) {
        count = new int[A.length + 1];
        size = 0;
        int result = 0;
        int left = 0, right = 0;
        while (right < A.length) {
            add(A[right]);
            while (size > k) {
                delete(A[left++]);
            }
            result += right + 1 - left;
            right++;
        }
        return result;
    }
}
