package com.company.day1030;

public class InversePairs_Solution {
    /**
     * 数组中的逆序对
     *
     * @param array
     * @return
     */
    // 暴力法， 超时
    public static int InversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[i];
            for (int j = 0; j < i; j++) {
                if (array[j] > temp) {
                    res++;
                }
            }
        }
        return res;
    }

    // 归并排序
    static int count;

    public static int InversePairs2(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        MergeSort(array, 0, array.length - 1);
        return count;
    }

    private static void MergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        MergeSort(array, left, mid);
        MergeSort(array, mid + 1, right);
        Merge(array, left, mid, right);
    }

    private static void Merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int k = 0, i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                count = (count + (mid - i + 1)) % 1000000007;
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        for (int l = 0; l < k; l++) {
            array[left + l] = temp[l];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs2(arr));
    }
}
