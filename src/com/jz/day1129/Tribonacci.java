package com.jz.day1129;

import java.util.Scanner;

/**
 * 1137. 第 N 个泰波那契数
 */
public class Tribonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            System.out.println(tribonacci(n));
        }
        sc.close();
    }

    public static int tribonacci(int n) {
        int[] dp = new int[3];
        dp[1] = 1;
        dp[2] = 1;
        if (n == 0) return dp[0];
        if (n == 1 || n == 2) return dp[1];
        for (int i = 3; i <= n; i++) {
            int temp = dp[0] + dp[1] + dp[2];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = temp;
        }
        return dp[2];

    }
}
