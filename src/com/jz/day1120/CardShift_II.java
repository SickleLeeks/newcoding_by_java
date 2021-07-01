package com.jz.day1120;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 完美洗牌问题（2）
 */
public class CardShift_II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] arr = sc.nextLine().split(" ");
        sc.close();
        int[] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
        solution(n, nums);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void solution(int n, int[] nums) {
        if (nums.length <= 2) return;
        Arrays.sort(nums);
        for (int i = 1; i < n - 1; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
    }
}
