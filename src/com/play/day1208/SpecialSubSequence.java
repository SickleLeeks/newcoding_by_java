package com.play.day1208;

import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 牛牛的特殊子序列
public class SpecialSubSequence {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param x string字符串
     * @return int整型
     */
    public static int Maximumlength(String x) {
        int n = x.length();
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(mid, x)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return 3 * left;
    }

    private static boolean check(int len, String x) {
        //判断是否能找到这样长度为3*len的子序列
        int n = x.length();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < n; i++) {
            if (count1 < len) {
                if (x.charAt(i) == 'a') {
                    count1++;
                }
            } else if (count2 < len) {
                if (x.charAt(i) == 'b') {
                    count2++;
                }
            } else if (count3 < len) {
                if (x.charAt(i) == 'c') {
                    count3++;
                }
            }
        }
        return (count1 == len) && (count2 == len) && (count3 == len);
    }

    public static int Maximumlength1(String x) {
        if ("".equals(x) || x.length() == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i <= x.length() / 3; i++) {
            String aStr = String.join("", Collections.nCopies(i, "a"));
            String bStr = String.join("", Collections.nCopies(i, "b"));
            String cStr = String.join("", Collections.nCopies(i, "c"));
            String target = aStr + bStr + cStr;
            System.out.println(target);
            if (x.contains(target)) {
                max = Math.max(max, target.length());
            }
        }
        return max;
    }

    public static int Maximumlength2(String x) {
        if ("".equals(x) || x.length() == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i <= x.length() / 3; i++) {
            String pattern = "[a]{" + i + "}[b]{" + i + "}[c]{" + i + "}";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(x);
            if (m.find()) {
                System.out.println(m.group());
                max = Math.max(max, m.group().length());
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String x = "abcaabbccc";
        System.out.println(Maximumlength(x));
    }
}
