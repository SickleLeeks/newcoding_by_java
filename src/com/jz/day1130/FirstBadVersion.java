package com.jz.day1130;

import java.util.Scanner;

/**
 * 278. 第一个错误的版本
 */
public class FirstBadVersion {
    private static int bad;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            bad = sc.nextInt();
            System.out.println(firstBadVersion(n));
        }
        sc.close();
    }

    public static int firstBadVersion(int n) {
        if (n == 1) return 1;
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isBadVersion(int n) {
        return n >= bad;
    }
}
