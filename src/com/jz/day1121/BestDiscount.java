package com.jz.day1121;

import java.util.Arrays;
import java.util.Scanner;

public class BestDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
            bestDiscount(arr);
            System.out.println(Arrays.toString(arr));
        }
        sc.close();
    }

    private static void bestDiscount(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int[] dp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                dp[i] = 0;
            } else {
                if (arr[i] < arr[i + 1]) {
                    dp[i] = dp[i + 1];
                } else {
                    dp[i] = arr[i + 1];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - dp[i];
        }
    }
}
