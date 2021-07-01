package com.jz.day1120;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 子数组的最大累加和问题
 */
public class MaxSumofSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine().trim();
            String[] newstr = str.substring(1, str.length() - 1).split(",");
            int[] arr = new int[newstr.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(newstr[i].trim());
            }
//            int[] arr = Arrays.stream(newstr).mapToInt(Integer::parseInt).toArray();
            int res1 = solution1(arr);
            int res2 = solution2(arr);
            System.out.println(res1 + " ：" + res2);
        }
        sc.close();
    }

    private static int solution1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int maxValue = dp[0];
        for (int i = 1; i < arr.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + arr[i];
            } else {
                dp[i] = arr[i];
            }
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }

    private static int solution2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int curr = arr[0]; //记录当前累加和
        int maxValue = curr;
        for (int i = 1; i < arr.length; i++) {
            curr = curr > 0 ? curr + arr[i] : arr[i];
            maxValue = Math.max(curr, maxValue);
        }
        return maxValue;
    }
}