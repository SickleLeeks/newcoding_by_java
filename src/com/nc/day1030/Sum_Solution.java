package com.nc.day1030;

public class Sum_Solution {
    /**
     * 求1+2+3+。。。+n
     *
     * @param n
     * @return
     */
    public static int Sum_Solution(int n) {
        return n * (1 + n) / 2;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(Sum_Solution(n));
    }
}
