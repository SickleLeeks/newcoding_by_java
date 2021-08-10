package com.jz.day1130;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 35. 搜索插入位置
 */
public class SearchInsert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());
            System.out.println(searchInsert(nums, target));
        }
        sc.close();
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] >= target ? 0 : 1;
        }
        if (nums[0] > target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                return mid;
            }
        }
        return left;
    }
}
