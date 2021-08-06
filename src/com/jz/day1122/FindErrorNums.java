package com.jz.day1122;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Leetcode645 错误的集合
 */
public class FindErrorNums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int[] res = findErrorNums2(nums);
            System.out.println(Arrays.toString(res));
        }
        sc.close();
    }

    public static int[] findErrorNums(int[] nums) {
        int[] error = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                error[0] = i;
            } else if (count == 0) {
                error[1] = i;
            }
        }
        return error;
    }

    //位运算
    public static int[] findErrorNums2(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        //与补充的n个元素计算异或和
        for (int i = 1; i <= nums.length; i++) {
            xor ^= i;
        }
        int lowbit = xor & (-xor); //获得最低不同位
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & lowbit) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if ((i & lowbit) == 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        //判断哪个是缺失的，哪个是重复的
        for (int num : nums) {
            if (num == num1) {
                return new int[]{num1, num2};
            }
        }
        return new int[]{num2, num1};
    }
}
