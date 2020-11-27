package com.nc.day1007;

public class LCS_Solution {
    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public static String LCS(String str1, String str2) {
        if (str1 == null || str2 == null || "".equals(str1) || "".equals(str2)) {
            return "-1";
        }
        int maxLen = 0, index = 0,m = str1.length(),n=str2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                if (maxLen < dp[i][j]) {
                    maxLen = dp[i][j];
                    index = i;
                }
            }
        }
        if (maxLen==0){
            return "-1";
        }
        return str1.substring(index - maxLen + 1, index + 1);
    }

    public static void main(String[] args) {
        String str1 = "1AB2345CD";
        String str2 = "1234EF";
        System.out.println(LCS(str1, str2));
    }
}
