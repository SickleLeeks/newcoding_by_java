package com.jz.day1106;

public class LeftRotateString_JZ {
    /**
     * 左旋转字符串
     *
     * @param str
     * @param n
     * @return
     */
    public static String LeftRotateString(String str, int n) {
        if ("".equals(str) || n == 0) {
            return str;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(str.substring(n));
        sb.append(str.substring(0, n));
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        int n = 2;
        System.out.println(LeftRotateString(str, n));
    }
}
