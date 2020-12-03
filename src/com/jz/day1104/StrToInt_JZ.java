package com.jz.day1104;

public class StrToInt_JZ {
    /**
     * 把字符串转换为整数
     *
     * @param str
     * @return
     */
    public static int StrToInt(String str) {
        if ("".equals(str) || str.length() == 0) {
            return 0;
        }
        boolean flag = false;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            flag = str.charAt(0) == '-';
            str = str.substring(1);
        }
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Math.abs(str.charAt(i) - '0') >= 10) {
                return 0;
            }
            if (str.charAt(i) - '0' != 0) {
                index = i;
                break;
            }
        }
        str = str.substring(index);
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Math.abs(str.charAt(i) - '0') >= 10 || res * 10 > Integer.MAX_VALUE) {
                return 0;
            }
            res = res * 10 + (str.charAt(i) - '0');
        }
        return flag ? res * -1 : res;
    }

    public static void main(String[] args) {
        String str = "1a33";
        System.out.println(StrToInt(str));
    }
}
