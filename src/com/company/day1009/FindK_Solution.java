package com.company.day1009;

import java.util.*;


class FindK_Solution {
    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_(int n, int v, int[] a) {
        if (a[n - 1] < v) {
            return n + 1;
        }
        if (a[0] >= v) {
            return 1;
        }
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= v) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int n = 5;
        int v = 4;
        int[] a = new int[]{1, 2, 4, 4, 5};
        int res = upper_bound_(n, v, a);
        System.out.println(res);
    }
}