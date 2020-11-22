package com.company.day1003;

public class Mountain_Solution {
    /**
     * 寻找最后的山峰
     *
     * @param a int整型一维数组
     * @return int整型
     */
    public static int solve(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }
        if (a.length == 1) {
            return a[0];
        }
        int i = a.length - 1;
        while (i >= 1) {
            if (a[i] >= a[i - 1]) {
                return i;
            }
            i--;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 2, 7, 8, 4};
        System.out.println(solve(arr));
    }
}
