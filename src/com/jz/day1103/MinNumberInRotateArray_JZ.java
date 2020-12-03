package com.jz.day1103;

public class MinNumberInRotateArray_JZ {
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0, right = array.length - 1;
        int mid = 0;
        while (left < right) {
            if (array[left] < array[right]) {
                return array[left];
            }
            mid = left + (right - left) / 2;
            if (array[mid] > array[left]) {
                left = mid + 1;
            } else if (array[mid] < array[right]) {
                right = mid;
            } else {
                left++;
            }
        }
        return array[mid];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(arr));
    }
}
