package com.company.day1029;

import java.util.HashSet;
import java.util.Set;

public class MinNumberdisappered_Solution {
    /**
     * 数组中未出现的最小正整数
     * return the min number
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int minNumberdisappered(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        set.add(arr[0]);
        int prev = arr[0];
        int MAX = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            set.add(arr[i]);
            int min = Math.min(prev, arr[i]);
            int max = Math.max(prev, arr[i]);
            MAX = Math.max(max, MAX);
            while (min < max) {
                if (min + 1 <= max && !set.contains(min) && min + 1 >= 2) {
                    res = min;
                    break;
                } else {
                    min = min + 1;
                }
            }
            prev = arr[i];
        }
        return res != 0 ? res : MAX + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(minNumberdisappered(arr));
    }
}
