package com.nc.day1011;

import java.util.ArrayList;

/**
 * 最小的K个数
 */
public class MinestKNum_Solution {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input == null || k <= 0 || k > input.length) {
            return arrayList;
        }
        quickSort(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;
    }

    private static void quickSort(int[] input, int low, int high) {
        if (low < high) {
            int index = getIndex(input, low, high);
            quickSort(input, low, index - 1);
            quickSort(input, index + 1, high);
        }
    }

    private static int getIndex(int[] input, int left, int right) {
        int X = input[left];
        while (left < right) {
            while (left < right && input[right] >= X) {
                right--;
            }
            input[left] = input[right];
            while (left < right && input[left] <= X) {
                left++;
            }
            input[right] = input[left];
        }
        input[left] = X;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        int K = 10;
        ArrayList<Integer> res = GetLeastNumbers_Solution(arr, K);
        res.forEach(System.out::print);
    }
}
