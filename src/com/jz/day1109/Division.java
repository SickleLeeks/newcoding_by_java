package com.jz.day1109;

public class Division {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回满足条件的最大的x。
     *
     * @param a int整型 代表题意中的a
     * @param b int整型 代表题意中的b
     * @param n int整型 代表题意中的n
     * @return int整型
     */
    public static int solve2(int a, int b, int n) {
        int x = n / a * a + b;
        if (x > n) {
            x -= a;
        }
        return x;
    }

    public static int solve(int a, int b, int n) {
        for (int i = n; i >= 0; i--) {
            if (i % a == b) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 1;
        int n = 1000000000;
        System.out.println(solve(a, b, n));
    }
}
