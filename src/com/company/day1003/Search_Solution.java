package com.company.day1003;

/**
 * 在转动过的有序数组中寻找目标值
 */
public class Search_Solution {
    /**
     * @param A      int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public static int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        if (A.length == 1) {
            return target == A[0] ? 0 : -1;
        }
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == A[mid]) {
                return mid;
            }
            if (A[mid] >= A[left]) {
                if (target < A[mid] && target >= A[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[]{4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(A, target));
    }
}
