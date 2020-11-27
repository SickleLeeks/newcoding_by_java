package com.nc.day1022;

// 最长公共子串
public class LCS_Solution {
    /**
     * longest common substring
     * 暴力搜索
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public static String LCS(String str1, String str2) {
        String longer = str1.length() >= str2.length() ? str1 : str2;
        String shorter = longer.equals(str1) ? str2 : str1;
        int l = 0;
        String res = "";
        for (int i = 0; i < shorter.length(); i++) {
            for (int j = i + 1; j <= shorter.length(); j++) {
                if (longer.contains(shorter.substring(i, j)) && j - i > l) {
                    l = j - i;
                    res = shorter.substring(i, j);
                }
            }
        }
        return res;
    }

    /**
     * 动态规划
     *
     * @param str1
     * @param str2
     * @return
     */
    public static String LCS2(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return "-1";
        }
        int[][] dp = new int[str1.length()][str2.length()];
        int max = 0;
        int index = -1;
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        index = i - max + 1;
                    }
                }
            }
        }
        if (max == -1) {
            return "-1";
        }
        return str1.substring(index, index + max);
    }

    public static void main(String[] args) {
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        System.out.println(LCS2(str1, str2));
    }
}
