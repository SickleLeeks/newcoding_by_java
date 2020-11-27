package com.nc.day1023;

/**
 * 最长回文子串
 */
public class GetLongestPalindrome_Solution {
    public static int getLongestPalindrome(String A, int n) {
        if (A == null || A.length() == 0) {
            return 0;
        }
        StringBuffer sb = new StringBuffer(A);
        String B = sb.reverse().toString();
        int max = 0;
        int[][] dp = new int[A.length()][B.length()];
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }
    // 动态规划
    public static int getLongestPalindrome2(String A, int n) {
        if (A == null || A.length() == 0) {
            return 0;
        }
        char[] charA = A.toCharArray();
        int max = 1;
        // dp[i][j]=True表示str[i...j]是回文子串，那么必定存在dp[i+1][j-1]=True
        boolean[][] dp = new boolean[n][n];
        // 初始化dp[i][i] = True
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // dp[i][j+1]=True if str[i] == str[i+1]
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j == 1) {
                    dp[j][i] = (charA[i] == charA[j]);
                    if (max < i - j + 1) {
                        max = i - j + 1;
                    }
                } else {
                    if (dp[j + 1][i - 1] && charA[i] == charA[j]) {
                        dp[j][i] = true;
                        if (max < i - j + 1) {
                            max = i - j + 1;
                        }
                    } else {
                        dp[j][i] = false;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "acbdcbbbdbdaaccbcacdacdccababcddabddaaaaaaabdbabcdddaacabacbacbbdabdacddbbadaacbbdcbccacacdabcabacacbbbdcccacdcdcdcbcbabdcdacdddbbabcaccddddddabdacaabccdcabcbcbabacaaaccaccaddabbdadcdacdcdbaadbcabdcdcaaacbcadccbbddbaddcaddcaadcbbcbbdcbdadcddabdddcdbddbbdabaaddcaadd";
        int n = 265;
        System.out.println(getLongestPalindrome2(str, n));
    }
}
