package com.nc.day1004;

import java.math.BigInteger;

public class BigNumMulti_Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串 第一个整数
     * @param t string字符串 第二个整数
     * @return string字符串
     */
    public static String solve(String s, String t) {
        if ("".equals(s) || "".equals(t)) {
            return "";
        }
        BigInteger b1 = new BigInteger(s);
        BigInteger b2 = new BigInteger(t);
        BigInteger res = b1.multiply(b2);
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String s = "11";
        String t = "99";
        System.out.println(solve(s, t));
    }
}
