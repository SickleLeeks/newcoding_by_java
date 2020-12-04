package com.jz.day1106;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsNumeric_JZ {
    /**
     * 表示数值的字符串
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        String pattern = "([+|-])?([\\d]+)?([.]?[\\d]+)?([e|E][+|-]?[\\d]+)?";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(new String(str));
        if (m.find()) {
            return m.group().equals(new String(str));
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "123.45e+6";
        char[] chars = str.toCharArray();
        System.out.println(isNumeric(chars));
    }
}
