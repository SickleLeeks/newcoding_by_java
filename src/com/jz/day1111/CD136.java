package com.jz.day1111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CD136 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        System.out.println(solution(str1, str2));
    }

    private static String solution(String str, String exp) {
        if (str.contains(".") || str.contains("*")) {
            return "NO";
        }
        if (exp.indexOf("*") == 0 || checkExp(exp)) {
            return "NO";
        }
        return isPattern( str, exp) ? "YES" : "NO";
    }

    private static boolean isPattern(String str, String exp) {
        int col = str.length();
        int row = exp.length();
        // 建立一个boolean数组，数组长度为(m+1)*(n+1)，多的一行一列表示空串的情况
        // 行为目标字符串，列为模式字符串
        boolean[][] arr = new boolean[row+1][col+1];
        arr[0][0] = true;
        // 第一行剩余元素全部变为false，因为exp如果是空串，那么只要str不是空串，都不能匹配
        for (int i = 1; i <= col; i++) {
            arr[0][i] = false;
        }
        // 初始化第0列，此时str是空串，所以只能是
        return false;
    }

    private static boolean checkExp(String exp) {
        int i = exp.indexOf("*");
        while (i != -1) {
            int ii = exp.indexOf("*", i + 1);
            if (ii == i + 1) {
                return true;
            }
            i = ii;
        }
        return false;
    }
}
