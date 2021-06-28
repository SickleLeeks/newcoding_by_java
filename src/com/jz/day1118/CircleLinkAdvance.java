package com.jz.day1118;

import java.util.Scanner;

/**
 * 环形约瑟夫问题
 * 使用数学公式计算：时间复杂度为O(n)
 */
public class CircleLinkAdvance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int alive = solution(n, m);
        System.out.println(alive);
    }

    private static int solution(int n, int m) {
        int s = 0;
        for (int i = 2; i <= n; i++) {
            s = (s + m) % i;
        }
        return s+1;
    }
}
