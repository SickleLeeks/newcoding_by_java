package com.jz.day1117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 最长回文子串
 */
public class GetLongestPalindrome {
    /**
     * 通过率：96.67%
     *
     * @param A
     * @param n
     * @return
     */
    public static int getLongestPalindrome(String A, int n) {
        // write code here
        if (A == null || A.length() == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (A.charAt(n - i) == A.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] != 0 ? dp[i - 1][j - 1] + 1 : 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    /**
     * 中心扩散法
     * 通过率 100%
     *
     * @param A
     * @param n
     * @return
     */
    public static int getLongestPalindrome2(String A, int n) {
        if (n < 2)
            return A.length();
        int maxLen = 0, i = 0;
        while (i < n) {
            //如果剩余子串长度小于目前查找到的最长回文子串的长度，直接终止循环,因为即使他是回文子串，也不是最长的，所以直接终止循环，不再判断
            if (n - i <= maxLen / 2) {
                break;
            }
            int left = i, right = i;
            while (right < n - 1 && A.charAt(right + 1) == A.charAt(right)) {
                ++right; //过滤掉重复的
            }
            //下次在判断的时候从重复的下一个字符开始判断
            i = right + 1;
            //然后往两边判断，找出回文子串的长度
            while (right < n - 1 && left > 0 && A.charAt(right + 1) == A.charAt(left - 1)) {
                ++right;
                --left;
            }
            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
            }
        }
        return maxLen;
    }

    /**
     * 动态规划法
     * 递推公式：dp[left][right]=s.charAt(left)==s.charAt(right)&&dp[left+1][right-1]
     *
     * @param A
     * @param n
     * @return
     */
    public static int getLongestPalindrome3(String A, int n) {
        if (n < 2) return A.length();
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];
        for (int right = 1; right < n; right++) {
            for (int left = 0; left < right; left++) {
                // 如果两个字符不相同，则肯定不能构成回文字符串
                if (A.charAt(left) != A.charAt(right)) {
                    continue;
                }
                // 如果两个字符串相同，则分为三种情况
                // 1. 如果只有一个字符串，则肯定是回文子串
                if (right == left) {
                    dp[left][right] = true;
                } else if (right - left <= 2) {
                    //2.类似于"aa"和"aba"，也是回文子串
                    dp[left][right] = true;
                } else {
                    //3. 类似于"a******a"，要判断他是否是回文子串，只需要判断"******"是否是回文子串即可
                    dp[left][right] = dp[left + 1][right - 1];
                }
                // 如果字符串从left到right是回文子串，只需要保存最长的即可
                if (dp[left][right] && right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int res = getLongestPalindrome2(str, n);
        System.out.println(res);
    }
}
