package com.play.day1204;

/**
 * 音符选取
 */
public class BangBang {
    /**
     * @param n int整型 乐谱总音符数
     * @param m int整型 重音符数
     * @param k int整型 重音符之间至少的间隔
     * @return long长整型
     */
    public static long solve_bangbang(int n, int m, int k) {
        // 定义动态规划数组，dp[i][j]表示在前i个字符中选择j个重音符的组合数
        if (m == 0) {
            return 1;
        }
        long result = 0;
        if (n >= (m - 1) * k + m) { // 保证可以找到m个满足条件的重音符
            long[][] dp = new long[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                dp[i][1] = i;
            }
            for (int i = k + 2; i <= n; i++) {
                for (int j = 2; j <= m; j++) {
                    //dp[i][j]的组合数等于第i个字符是重音符的组合数+不是重音符的组合数
                    //如果是组合数：dp[i-k-1][j-1] ,,这里保证下标合法的，即i-k-1>=1，则i>=k+2
                    //如果不是组合数：dp[i-1][j]
                    dp[i][j] = (dp[i - 1][j] + dp[i - k - 1][j - 1]) % 1000000007;
                }
            }
            result = dp[n][m];
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        int k = 1;
        System.out.println(solve_bangbang(n, m, k));
    }
}
