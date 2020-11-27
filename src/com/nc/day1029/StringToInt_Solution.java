package com.nc.day1029;

public class StringToInt_Solution {
    /**
     * 将字符串转换为整数
     *
     * @param str string字符串
     * @return int整型
     */
    public static int atoi(String str) {
        if ("".equals(str)) {
            return 0;
        }
        boolean flag = true;
        char[] chars;
        str = str.trim();
        if (str.charAt(0) == '-') {
            flag = false;
            chars = str.substring(1).toCharArray();
        } else if (str.charAt(0) == '+') {
            chars = str.substring(1).toCharArray();
        } else {
            chars = str.toCharArray();
        }
        int begin = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                if (chars[i] != '0') {
                    begin = i;
                    break;
                }
            } else {
                return 0;
            }
        }
        int res = 0;
        int count = 0;
        while (begin < chars.length) {
            if (chars[begin] >= '0' && chars[begin] <= '9') {
                int k = chars[begin] - '0';
                if (count + 1 > String.valueOf(Integer.MAX_VALUE).length()) {
                    return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                res = res * 10 + k;
                count++;
            } else {
                break;
            }
            begin++;
        }
        return flag ? res : res * -1;
    }

    public static void main(String[] args) {
        String str = "       -10441643317j";
        System.out.println(atoi(str));
    }
}
