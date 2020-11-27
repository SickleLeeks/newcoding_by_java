package com.nc.day1008;

// 最小编辑代价
public class MinEditCost_Solution {
    /**
     * min edit cost
     * 动态规划：dp[i][j]表示word1的前i个字符编辑成word2的前j个字符需要的最小操作数
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @param ic   int整型 insert cost
     * @param dc   int整型 delete cost
     * @param rc   int整型 replace cost
     * @return int整型
     */
    public static int minEditCost(String str1, String str2, int ic, int dc, int rc) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dc*i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = ic*i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int del = dp[i - 1][j] + dc;
                    int add = dp[i][j - 1] + ic;
                    int cdt = dp[i - 1][j - 1] + rc;
                    dp[i][j] = Math.min(del, Math.min(add, cdt));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "adc";
        int ic = 5;
        int dc = 3;
        int rc = 2;

        System.out.println(minEditCost(str1, str2, ic, dc, rc));
    }
}
