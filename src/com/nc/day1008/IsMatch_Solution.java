package com.nc.day1008;

public class IsMatch_Solution {
    /**
     * 通配符匹配
     * 知识点：贪心、字符串、动态规划、回溯
     *
     * @param s
     * @param p
     * @return
     */

    // 递归实现：超时
    public static boolean isMatch1(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        if (pLen == 0) {
            return sLen == 0;
        }
        if (sLen == 0) {
            for (int i = 0; i < pLen; i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        if (p.charAt(pLen - 1) == '?' || s.charAt(sLen - 1) == p.charAt(pLen - 1)) {
            return isMatch1(s.substring(0, sLen - 1), p.substring(0, pLen - 1));
        }
        if (p.charAt(pLen - 1) == '*') {
            for (int i = 0; i <= sLen; i++) {
                if (isMatch1(s.substring(0, i), p.substring(0, pLen - 1))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 动态规划实现
     * f(x,y)：字符串s中[0,x-1]范围内的字符串能否匹配字符串p中[0,y-1]范围内的字符串
     * 状态转移：
     * 1. 如果p(y)=='?', 则f(x,y)=f(x-1,y-1)
     * 2. 如果p(y)==s(x)，则f(x,y)=f(x-1,y-1)
     * 3. 如果p(y)=='*'，则f(x,y)=f(x,y-1)||f(x-1,y-1)||f(x-2,y-1)||...||f(0,y-1);
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch2(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] matched = new boolean[sLen + 1][pLen + 1];
        matched[0][0] = true;
        for (int i = 1; i < pLen + 1; i++) {
            matched[0][i] = true;
            for (int j = 0; j <= i - 1; j++) {
                if (p.charAt(j) != '*') {
                    matched[0][i] = false;
                }
            }
        }
        for (int i = 1; i < matched.length; i++) {
            for (int j = 1; j < matched[0].length; j++) {
                if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    matched[i][j] = matched[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    for (int k = 0; k <= i; k++) {
                        if (matched[i][j]) {
                            break;
                        }
                        matched[i][j] = matched[i][j] || matched[k][j - 1];
                    }
                }
            }
        }
        return matched[sLen][pLen];
    }

    public static void main(String[] args) {
        String s = "ab";
        String p = "?*";
        System.out.println(isMatch2(s, p));
    }
}
