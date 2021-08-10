package com.jz.day1130;

import java.util.Scanner;

/**
 * 剑指 Offer 67. 把字符串转换成整数
 */
public class StrToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(strToInt(str));
        }
        sc.close();
    }

    public static int strToInt(String str) {
        String str1 = str.trim();
        int leftZero = 0;
        boolean hasNum = false;
        while (leftZero < str1.length()) {

            if (str1.charAt(leftZero) - '0' != 0) {
                str1 = str1.substring(leftZero);
                break;
            }
            if (str1.charAt(leftZero) - '0' >= 0 && str1.charAt(leftZero) - '0' <= 9) {
                hasNum = true;
            }
            leftZero++;
        }
        if (leftZero == str1.length()) return 0;
        char[] chars = str1.toCharArray();
        int res = 0;
        boolean positive = true;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                if (chars[i] == '-' || chars[i] == '+') {
                    if (hasNum) return 0;
                    positive = chars[i] == '+';
                } else if (chars[i] < '0' || chars[i] > '9') {
                    return 0;
                } else {
                    res = chars[i] - '0';
                }
            } else {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    if (res * 10 / 10 != res) {
                        return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    } else {
                        res = res * 10 + chars[i] - '0';
                    }
                } else {
                    break;
                }
            }
        }
        return positive ? (res < 0 ? Integer.MAX_VALUE : res) : (-res > 0 ? Integer.MIN_VALUE : -res);
    }
}
