package com.jz.day1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 数组的Partition2调整补充问题
 */
public class Partition2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        partition(arr);
        for (int i = 0; i < N - 1; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    private static void partition(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int left = -1;
        int right = arr.length;
        int i = 0;
        while (i < right) {
            if (arr[i] == 0) {
                swap(arr, ++left, i);
                i++;
            } else if (arr[i] == 2) {
                swap(arr, --right, i);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
