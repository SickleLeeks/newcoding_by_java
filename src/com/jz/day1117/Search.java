package com.jz.day1117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 二分查找
 */
public class Search {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 如果目标值存在返回下标，否则返回 -1
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int search(int[] nums, int target) {
        // write code here
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                while (mid >= low) {
                    if (nums[mid] == target) {
                        mid--;
                    } else {
                        break;
                    }
                }
                return mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(",");
        int target = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        int res = search(nums, target);
        System.out.println(res);
    }
}
