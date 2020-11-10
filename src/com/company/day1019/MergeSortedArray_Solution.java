package com.company.day1019;

import java.util.Arrays;

public class MergeSortedArray_Solution {
    public static int[] merge(int[] A, int m, int[] B, int n) {
        int[] merge = new int[m + n];
        int pA = 0, pB = 0;
        int index = 0;
        while (pA < m && pB < n) {
            if (A[pA] <= B[pB]) {
                merge[index++] = A[pA++];
            } else {
                merge[index++] = B[pB++];
            }
        }
        while (pA < m) {
            merge[index++] = A[pA++];
        }
        while (pB < n) {
            merge[index++] = B[pB++];
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = merge[i];
        }
        return A;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 5, 7};
        int[] arr2 = new int[]{2, 4, 6, 8};
        int m = arr1.length;
        int n = arr2.length;

        int[] res = merge(arr1, m, arr2, n);
        System.out.println(Arrays.toString(res));
    }
}
