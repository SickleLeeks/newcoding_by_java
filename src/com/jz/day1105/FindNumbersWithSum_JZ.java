package com.jz.day1105;

import java.util.ArrayList;

public class FindNumbersWithSum_JZ {
    /**
     * 和为s的两个数字
     *
     * @param array
     * @param sum
     * @return
     */
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length == 0) {
            return res;
        }
        int[][] mat = new int[array.length][array.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (sum == array[i] + array[j] && min > array[i] * array[j]) {
                    res.clear();
                    res.add(array[i]);
                    res.add(array[j]);
                    min = array[i] * array[j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 7, 11, 15};
        int sum = 15;
        System.out.println(FindNumbersWithSum(array, sum));
    }
}
