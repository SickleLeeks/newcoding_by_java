package com.jz.day1117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class MySort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(MySort(nums)));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public static int[] MySort(int[] arr) {
        // write code here
        if (arr.length == 1) {
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            int key = arr[i];
            while (i < j) {
                while (i < j && arr[j] >= key) {
                    j--;
                }
                if (i < j) {
                    arr[i] = arr[j];
                }
                while (i < j && arr[i] <= key) {
                    i++;
                }
                if (i < j) {
                    arr[j] = arr[i];
                }
            }
            arr[i] = key;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
}