package com.jz.day1120;

import java.util.Scanner;

public class CardShift_I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] strs = sc.nextLine().split(" ");
        sc.close();
        for (int i = 0; i < n / 2; i++) {
            System.out.print(strs[n / 2 + i] + " " + strs[i] + " ");
        }
    }
}
