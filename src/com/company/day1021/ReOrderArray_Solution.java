package com.company.day1021;

import java.util.ArrayList;
import java.util.Arrays;

public class ReOrderArray_Solution {
    /**
     * 调整数组顺序使奇数位于偶数前面
     * @param array
     * @return
     */
    public static int[] reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return array;
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
        for (int i = 0; i < odd.size(); i++) {
            array[i] = odd.get(i);
        }
        for (int i = 0; i < even.size(); i++) {
            array[i+odd.size()] = even.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] res = reOrderArray(arr);
        System.out.println(Arrays.toString(res));
    }
}
