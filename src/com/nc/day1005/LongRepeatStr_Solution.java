package com.nc.day1005;

import java.util.HashMap;
import java.util.Map;

public class LongRepeatStr_Solution {
    /**
     * 最长重复子串
     *
     * @param a
     * @return
     */
    // 通过率100%
    public static int solve2(String a) {
        if (a == null || a.length() == 0) {
            return 0;
        }
        int len = a.length();
        for (int i = len / 2; i >= 0; i--) {
            for (int j = 0; j <= len - 2 * i; j++) {
                if (isEqual(a, j, i)) {
                    return i * 2;
                }
            }
        }
        return 0;
    }

    private static boolean isEqual(String a, int start, int len) {
        for (int i = 0; i < len; i++) {
            if (a.charAt(i + start) != a.charAt(len + start + i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 最长重复子串
     * 设置窗口大小为I，初始值为字符长度的一半，逐渐减少窗口长度；
     * 从字符串头部开始滑动窗口，直到匹配成功
     *
     * @param a
     * @return
     */
    // 通过率 80%
    public static int solve(String a) {
        if (a == null || a.length() == 0) {
            return 0;
        }
        int L = a.length() / 2;
        while (L > 0) {
            Loop:
            for (int i = 0; 2 * L + i < a.length(); i++) {
                for (int j = i; j < L + i; j++) {
                    if (a.charAt(j) != a.charAt(L + j)) {
                        continue Loop;
                    }
                }
                return L * 2;
            }
            L--;
        }
        return 0;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a string字符串 待计算字符串
     * @return int整型
     */
    // 通过率0%
    public static int my_solve(String a) {
        if (a == null || a.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < a.length(); i++) {
            if (!map.containsKey(a.charAt(i))) {
                map.put(a.charAt(i), i);
            } else {
                int j = map.get(a.charAt(i));
                int len = i - j;
                for (int k = j; k < i; k++) {
                    if (len + k < a.length() && a.charAt(k) == a.charAt(k + len)) {
                        continue;
                    } else {
                        return 0;
                    }
                }
                res = Math.max(res, len);
                map = new HashMap<>();
                map.put(a.charAt(i), i);
            }
        }
        return res * 2;
    }

    public static void main(String[] args) {
        String str = "ababcabc";
        System.out.println(solve2(str));
    }
}
