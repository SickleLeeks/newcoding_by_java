package com.nc.day1020;

public class GetNumberOfK_Solution {
    public static int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 0;
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > k) {
                right = mid - 1;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                if (array[left] != k) {
                    left++;
                }
                if (array[right] != k) {
                    right--;
                }
                if (array[left] == k && array[right] == k) {
                    break;
                }
            }
        }
        count = right - left + 1;
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,3,3,3,4,5};
        int k = 2;
        System.out.println(GetNumberOfK(arr, k));
    }
}
