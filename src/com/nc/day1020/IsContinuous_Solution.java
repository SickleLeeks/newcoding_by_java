package com.nc.day1020;

import java.util.HashSet;
import java.util.Set;

public class IsContinuous_Solution {
    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int min = 14;
        int max = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0 && !set.contains(numbers[i])) {
                set.add(numbers[i]);
                min = Math.min(min, numbers[i]);
                max = Math.max(max, numbers[i]);
            } else if (set.contains(numbers[i])) {
                return false;
            }
        }
        if (max - min < 5) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] num = new int[]{0, 3, 2, 6, 4};
        System.out.println(isContinuous(num));
    }
}
