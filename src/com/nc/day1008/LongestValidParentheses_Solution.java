package com.nc.day1008;

import java.util.Stack;

/**
 * 最长的括号子串
 */
public class LongestValidParentheses_Solution {
    /**
     * @param s string字符串
     * @return int整型
     */
    // 使用栈
    public static int longestValidParentheses(String s) {
        if ("".equals(s) || s.length() == 0) {
            return 0;
        }
        // stack中保存左括号的索引
        Stack<Integer> stack = new Stack<>();
        int maxlen = 0;
        int last = -1;
        for (int i = 0; i < s.length(); i++) {
            // 左括号入栈
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // 栈为空，更新起始点位置
                if (stack.isEmpty()) {
                    last = i;
                } else {
                    stack.pop();
                    // 更新合法括号的长度
                    if (stack.isEmpty()) {
                        maxlen = Math.max(maxlen, i - last);
                    } else {
                        maxlen = Math.max(maxlen, i - stack.peek());
                    }
                }
            }
        }
        return maxlen;
    }

    // 动态规划
    public static int longestValidParentheses2(String s) {
        if ("".equals(s) || s.length() == 0) {
            return 0;
        }
        int maxlen = 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                int index = i - dp[i - 1] - 1;
                if (index >= 0 && s.charAt(index) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (index - 1 >= 0 && dp[index - 1] > 0) {
                        dp[i] += dp[index - 1];
                    }
                }
            }
            maxlen = Math.max(maxlen, dp[i]);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String str = "(()";
        System.out.println(longestValidParentheses(str));
    }
}
