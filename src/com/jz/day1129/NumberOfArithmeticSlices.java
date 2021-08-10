package com.jz.day1129;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 等差数列划分
 */
public class NumberOfArithmeticSlices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            System.out.println(numberOfArithmeticSlices(nums));
        }
        sc.close();
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int count = 2, diff = nums[1] - nums[0];
        int res = 0;
        for (int i = 2; i <= nums.length - 1; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                count++;
            } else {
                for (int j = 3; j <= count; j++) {
                    res += (count - j + 1);
                }
                diff = nums[i] - nums[i - 1];
                count = 2;
            }
        }
        if (count >= 3) {
            for (int j = 3; j <= count; j++) {
                res += (count - j + 1);
            }
        }
        return res;
    }
}
