package com.nc.day1012;

public class Sqrt_Solution {
    /**
     * @param x int整型
     * @return int整型
     */
    public static int sqrt(int x) {
        // write code here
        if (x <= 0) {
            return 0;
        }
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x / mid > mid) {
                left = mid+1;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else if (x / mid == mid) {
                return mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(1518991037));
    }
}
