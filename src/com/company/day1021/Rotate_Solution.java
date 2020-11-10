package com.company.day1021;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Rotate_Solution {
    /**
     * 旋转数组
     *
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public static int[] solve(int n, int m, int[] a) {
        m = m % n;
        if (m == 0) {
            return a;
        }
        reverse(a, n - m, n - 1);
        reverse(a, 0, n - m - 1);
        reverse(a, 0, n - 1);
        return a;
    }

    private static void reverse(int[] a, int left, int right) {
        while (left < right) {
            int tmp = a[left];
            a[left] = a[right];
            a[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int m = 7;
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(solve(n, m, arr)));
    }
}
