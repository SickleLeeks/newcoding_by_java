package com.jz.day1113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 剑指Offer：正则表达式匹配
 */
public class Match {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(",");
        boolean res = match2(strs[0], strs[1]);
        System.out.println(res);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 动态规划法
     *
     * @param str     string字符串
     * @param pattern string字符串
     * @return bool布尔型
     */
    public static boolean match(String str, String pattern) {
        // write code here
        int row = str.length(); // 行数
        int col = pattern.length(); // 列数
        boolean[][] dp = new boolean[row + 1][col + 1];
        dp[0][0] = true;
        for (int i = 1; i <= col; i++) {
            if (pattern.charAt(i - 1) == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern.charAt(j - 1) == '*') {
                    if (dp[i][j - 2]) {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        if (str.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.') {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[row][col];
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 递归法
     *
     * @param str     string字符串
     * @param pattern string字符串
     * @return bool布尔型
     */
    public static boolean match2(String str, String pattern) {
        return re_match(str, pattern, 0, 0);
    }

    private static boolean re_match(String str, String pattern, int i, int j) {
        if (i == str.length() && j == pattern.length()) {
            return true;
        }
        if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
            return re_match(str, pattern, i, j + 2) || (i != str.length()) && ((str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') && re_match(str, pattern, ++i, j));
        } else {
            return (i != str.length()) && j != pattern.length() && (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.') && re_match(str, pattern, ++i, ++j);
        }
    }
}
