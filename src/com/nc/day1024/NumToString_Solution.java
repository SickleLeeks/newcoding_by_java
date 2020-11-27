package com.nc.day1024;

public class NumToString_Solution {
    /**
     * 解码
     *
     * @param nums string字符串 数字串
     * @return int整型
     */
    public static int solve(String nums) {
        if (nums == null || nums.length() == 0) {
            return 0;
        }
        if (nums.length() == 1) {
            return 1;
        }
        if (nums.length() == 2 && Integer.parseInt(nums) <= 26) {
            return 2;
        }
        int res = 0, i = 0;
        while (i < nums.length()) {
            int key = Integer.parseInt(String.valueOf(nums.charAt(i)));
            if (i == 0 && key >= 1 && key <= 26) {
                res = 1;
                i++;
            } else if (Integer.parseInt(String.valueOf(nums.charAt(i - 1))) > 2) {
                i++;
            } else if (Integer.parseInt(String.valueOf(nums.charAt(i))) > 2) {
                res = res * 2;
                i++;
            } else if (i + 1 < nums.length() && Integer.parseInt(String.valueOf(nums.charAt(i + 1))) <= 6) {
                res = res * 3;
                i += 2;
            }
        }
        return res;
    }

    public static int solve2(String nums) {
        if (nums.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[nums.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        if (nums.length() == 1) {
            return dp[1];
        }
        for (int i = 2; i <= nums.length(); i++) {
            int num = Integer.parseInt(String.valueOf(nums.charAt(i - 1)));
            int num2 = Integer.parseInt(String.valueOf(nums.charAt(i - 2)));
            if (num2 + num == 0 || (num == 0 && num2 > 2)) {
                return 0;
            } else if (num == 0 || num2 == 0) {
                dp[i] = num2 == 0 ? dp[i - 2] : dp[i - 1];
            } else {
                dp[i] = num2 * 10 + num > 26 ? dp[i - 1] : dp[i - 2] + dp[i - 1];
            }
        }
        return dp[nums.length()];
    }

    public static int solve3(String nums) {
        int len = nums.length();
        if (len == 0) {
            return 0;
        }
        // dp[i]以s[i]结尾的前缀子串有多少种解码方法
        // dp[i] = dp[i-1]*1 if s[i]!='0'
        // dp[i] += dp[i-2]*1 if 10<= int(s[i-1...i])<=26
        int[] dp = new int[len];
        char[] chars = nums.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (chars[i] != '0') {
                dp[i] = dp[i - 1];
            }
            int num = 10 * (chars[i - 1] - '0') + (chars[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        String num = "01";
        System.out.println(solve3(num));
    }
}
