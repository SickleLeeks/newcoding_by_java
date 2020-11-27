package com.nc.day1012;

public class ReverseString_Solution {
    /**
     * 反转字符串
     *
     * @param str string字符串
     * @return string字符串
     */
    public static String solve(String str) {
        // write code here
        if (str == null || str.length() == 0) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abcd";
        String res = solve(str);
        System.out.println(res);
    }
}
