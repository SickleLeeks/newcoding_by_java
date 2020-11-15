package com.company.day1027;

import java.util.Arrays;

/**
 * 整数的二进制表达中有多少个1
 */
public class NumberOf1_Solution {
    // 方法1
    public static int NumberOf1(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    // 方法2
    public static int NumberOf12(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = -2147483648;
        System.out.println(NumberOf1(n));
    }
}
