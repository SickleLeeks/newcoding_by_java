package com.nc.day1016;

public class ReverseNum_Solution {

    public static int reverse0(int x) {
        int res = 0;
        while (x != 0) {
            int tail = x % 10;
            int newres = res * 10 + tail;
            // 判断产生溢出
            if ((newres - tail) / 10 != res) {
                return 0;
            }
            res = newres;
            x = x / 10;
        }
        return res;
    }

    /**
     * @param x int整型
     * @return int整型
     */
    public static String reverse(String x) {
        if (x == null | "".equals(x)) {
            return x;
        }
        if (x.length() == 1 && x.charAt(0) == '-') {
            return x;
        }
        if (x.charAt(0) == '-') {
            return "-" + numreverse(x.substring(1, x.length()));
        } else {
            return numreverse(x);
        }
    }

    private static String numreverse(String substring) {
        StringBuffer sb = new StringBuffer();
        for (int i = substring.length() - 1; i >= 0; i--) {
            sb.append(substring.charAt(i));
        }
        String str = sb.toString();
        ;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                str = str.substring(i, str.length());
                break;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String num = "-1000000001100200";
        String res = reverse(num);
        System.out.println(res);
    }
}
