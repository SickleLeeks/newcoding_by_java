package com.nc.day1008;

/**
 * 在两个长度相等的排序数组中找到上中位数
 */
public class FindMedianinTwoSortedAray_Solution {
    /**
     * find median in two sorted array
     *
     * @param arr1 int整型一维数组 the array1
     * @param arr2 int整型一维数组 the array2
     * @return int整型
     */
    // 从两个数组中不断找较小者，找到第n个就返回
    public static int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        int len = arr1.length;
        int a1 = 0;
        int a2 = 0;
        while (len>1){
            if (arr1[a1]<=arr2[a2]){
                a1++;
            }else {
                a2++;
            }
            len--;
        }
        return Math.min(arr1[a1],arr2[a2]);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{3, 4, 5, 6};
        System.out.println(findMedianinTwoSortedAray(arr1, arr2));
    }
}
