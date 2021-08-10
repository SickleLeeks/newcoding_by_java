package com.jz.day1129;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 704. 二分查找
 */
public class Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(sc.nextLine());
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
