package com.nc.day1016;

import java.util.Arrays;

public class MoreThanHalfNum_Solution {
    public static int moreThanHalfNum(int[] array) {
        if (array == null) {
            return 0;
        }
        Arrays.sort(array);
        int count = 0;
        int mid = array.length / 2;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[mid]) {
                count++;
            }
        }
        if (count > mid) {
            return array[mid];
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2, 4, 2, 5, 2, 3};
        int res = moreThanHalfNum(arr);
        System.out.println(res);
    }
}
