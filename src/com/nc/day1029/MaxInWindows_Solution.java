package com.nc.day1029;

import java.util.ArrayList;

public class MaxInWindows_Solution {
    /**
     * 滑动窗口的最大值
     *
     * @param num
     * @param size
     * @return
     */
    static ArrayList<Integer> res = new ArrayList<>();

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null || size > num.length || size <= 0) {
            return res;
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (num[i] > max) {
                max = num[i];
                index = i;
            }
        }
        res.add(max);
        for (int i = size; i < num.length; i++) {
            if (i - index < size) {
                if (num[i] < max) {
                    res.add(max);
                } else {
                    max = num[i];
                    res.add(num[i]);
                    index = i;
                }
            } else {
                max = Integer.MIN_VALUE;
                for (int j = i; j > i - size; j--) {
                    if (num[j] > max) {
                        max = num[j];
                        index = j;
                    }
                }
                res.add(max);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{10, 14, 12, 11};
        int size = 5;
        System.out.println(maxInWindows(num, size));
    }
}
