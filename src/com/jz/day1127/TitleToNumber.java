package com.jz.day1127;

import java.util.Scanner;

/**
 * Leetcode 171 Excel表列序号
 */
public class TitleToNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(titleToNumber(str));
        }
        sc.close();
    }

    public static int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int res = 0;
        if (n == 0) {
            return res;
        }
        for (int i = 0; i < n; i++) {
            res += (columnTitle.charAt(i) - 'A' + 1) * Math.pow(26, n - i - 1);
        }
        return res;
    }
}
