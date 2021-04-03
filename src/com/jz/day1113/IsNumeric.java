package com.jz.day1113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 剑指offer: 表示数值的字符串
 */
public class IsNumeric {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean res = isNumeric(str);
        System.out.println(res);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串
     * @return bool布尔型
     */
    public static boolean isNumeric(String str) {
        // write code here
        if (str == null || str.length() == 0) {
            return false;
        }
        char[] chars = str.toCharArray();
        boolean point = false; //表示小数点是否已存在
        boolean e = false; //表示e是否已存在
        boolean Loperator = false; //表示e左边运算符是否已存在
        boolean Roperator = false; //表示e右边运算符是否已存在
        int len = chars.length;
        int eIndex = len; //表示e出现的位置
        if (len == 1) {
            return chars[0] >= '0' && chars[0] <= '9';
        }
        for (int i = 0; i < len; i++) {
            if (chars[i] == 'e' || chars[i] == 'E') {
                // e只能有1个，且不能位于首位和末尾
                if (!e && i != 0 && i != len - 1) {
                    eIndex = i;
                    e = true;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (chars[i] == '.') {
                // 小数点只能有一个，且必须在e前面
                if (point || i > eIndex) {
                    return false;
                } else {
                    point = true;
                }
            } else if (chars[i] == 'e' || chars[i] == 'E') {
                // e只能有1个，且不能位于首位和末尾
                if (i == 0 || i == len - 1) {
                    return false;
                }
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (i < eIndex) {
                    // e左边运算符只能有1个，并且只能再首位
                    if (Loperator || i != 0 || eIndex - i == 1) {
                        return false;
                    } else {
                        Loperator = true;
                    }
                } else {
                    // e右边运算符只能有1个，并且只能紧挨着e后面
                    if (Roperator || i - eIndex != 1 || i == len - 1) {
                        return false;
                    } else {
                        Roperator = true;
                    }
                }
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                // 数字可以出现在任何地方
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
