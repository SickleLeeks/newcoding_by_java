package com.company.day1021;

import java.util.ArrayList;
import java.util.Arrays;

public class ReOrderArray_Solution {
    public static int[] reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{};
        }
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int value : array) {
            if (value % 2 == 0) {
                even.add(value);
            } else {
                odd.add(value);
            }
        }
        odd.addAll(even);
        int[] res = new int[odd.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = odd.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] res = reOrderArray(arr);
        System.out.println(Arrays.toString(res));
    }
}
