package com.nc.day1007;

public class LastRemaining_Solution {
    /**
     * 约瑟夫环问题的变形
     * @param n
     * @param m
     * @return
     */
    public static int LastRemaining_Solution(int n, int m) {
        int res = -1;
        for (int i = 1; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        System.out.println(LastRemaining_Solution(n, m));
    }
}
