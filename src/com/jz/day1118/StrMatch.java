package com.jz.day1118;

import java.util.Scanner;

public class StrMatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] str = in.nextLine().trim().toCharArray();
        char[] exp = in.nextLine().trim().toCharArray();
        in.close();
        if (!isValid(str, exp)) {
            System.out.println("NO");
            return;
        }
//        boolean flag = isMatch1(str, exp, 0, 0);
        boolean flag = isMatch2(str, exp, str.length, exp.length);
        System.out.println(flag ? "YES" : "NO");
    }

    private static boolean isValid(char[] str, char[] exp) {
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '.' || str[i] == '*') {
                return false;
            }
        }
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == '*' && (i == 0 || exp[i - 1] == '*')) {
                return false;
            }
        }
        return true;
    }

    // 使用递归方法
    private static boolean isMatch1(char[] str, char[] exp, int iStr, int iExp) {
        if (iExp == exp.length) {
            return iStr == str.length;
        }
        if (iExp + 1 == exp.length || exp[iExp + 1] != '*') {
            return iStr != str.length && (exp[iExp] == str[iStr] || exp[iExp] == '.') && isMatch1(str, exp, iStr + 1, iExp + 1);
        }
        while (iStr != str.length && (exp[iExp] == str[iStr] || exp[iExp] == '.')) {
            if (isMatch1(str, exp, iStr, iExp + 2)) {
                return true;
            }
            iStr++;
        }
        return isMatch1(str, exp, iStr, iExp + 2);
    }

    // 动态规划
    private static boolean isMatch2(char[] str, char[] exp, int n, int m) {
        boolean[][] f = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //分成空模式串和非空模式串两种情况
                if (j == 0) {
                    f[i][j] = i == 0;
                } else {
                    //非空模式串分为两种情况*和非*
                    if (exp[j - 1] != '*') {
                        if (i > 0 && (str[i - 1] == exp[j - 1] || exp[j - 1] == '.')) {
                            f[i][j] = f[i - 1][j - 1];
                        }
                    } else {
                        //碰到*，则分为两种情况
                        if (j >= 2) {
                            f[i][j] |= f[i][j - 2];
                        }
                        if (i >= 1 && j >= 2 && (str[i - 1] == exp[j - 2] || exp[j - 2] == '.')) {
                            f[i][j] |= f[i - 1][j];
                        }
                    }
                }
            }
        }
        return f[n][m];
    }
}
