package com.nc.day1023;

/**
 * 最长公共子序列
 */
public class LCS_Solution {
    /**
     * longest common subsequence
     *
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public static String LCS(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return "-1";
        }
        char[] chr1 = s1.toCharArray();
        char[] chr2 = s2.toCharArray();
        int[][] dp = getdp(chr1, chr2);
        int m = chr1.length - 1;
        int n = chr2.length - 1;
        char[] res = new char[dp[m][n]];
        int index = res.length - 1;
        while (index >= 0) {
            if (n > 0 && dp[m][n] == dp[m][n - 1]) {
                n--;
            } else if (m > 0 && dp[m][n] == dp[m - 1][n]) {
                m--;
            } else {
                res[index--] = chr1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }

    private static int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        for (int i = 1; i < str2.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], str1[0] == str2[i] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA45B6A";
        System.out.println(LCS(str1, str2));
    }
}
