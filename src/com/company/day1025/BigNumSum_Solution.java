package com.company.day1025;

import java.math.BigInteger;

public class BigNumSum_Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public static String solve (String s, String t) {
        BigInteger num1 = new BigInteger(s);
        BigInteger num2 = new BigInteger(t);
        return String.valueOf(num1.add(num2));
    }

    public static void main(String[] args) {
        String s = "1258994789086810959258888307221656691275942378416703768";
        String t = "7007001981958278066472683068554254815482631701142544497";
        // 8265996771045089025731571375775911506758574079559248265
        System.out.println(solve(s,t));

    }
}
