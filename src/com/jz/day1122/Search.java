package com.jz.day1122;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());
            int res = search2(nums, target);
            System.out.println(res);
        }
        sc.close();
    }

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int leftIndex = binarySearch(nums, target, true); //查找数组中第一个大于等于target的位置
        int rightIndex = binarySearch(nums, target, false) - 1;//查找数组中第一个大于target的位置,然后将下标减一
        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return rightIndex - leftIndex + 1;
        }
        return 0;
    }

    private static int binarySearch(int[] nums, int target, boolean flag) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (flag && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // 两次二分，分别采用寻找左侧边界的二分写法和寻找右侧边界的二分写法
    public static int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        int cnt = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //等于target时也减1，收缩右边界来锁定左侧边界
                right = mid - 1;
            }
        }
        //记录左边界
        int oldLeft = left;
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                //等于target时候也+1，收缩左边界来锁定右侧边界
                left = mid + 1;

            }
        }
        return right - oldLeft + 1;
    }
}
