package com.nc.day1017;

import java.util.Arrays;

public class MaxMulti_Solution {
    /**
     * 最大乘积
     *
     * @param A int整型一维数组
     * @return long长整型
     */
    public static long solve(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        Arrays.sort(A);
        int size = A.length;
        return Math.max(Long.parseLong(String.valueOf(A[0])) * A[1] * A[size - 1], Long.parseLong(String.valueOf(A[size - 1])) * A[size - 2] * A[size - 3]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3472, 7789, 7955, -7098, -9281, 6101, 5051, 7778, 3090, 7423, -7151, 5652, 1595, -8094, 677, -8324, 8347, -2482, 9313, -9338, -3157, 8559, 6945, 3618, 3087, 121, -8468, 3225, 1356, 6939, 2799, -7231, -6309, -5453, 633, -8689, -4776, 2714, -2743, -1409, 5918, -3333, 1803, 8330, -2206, -6117, -4486, -7903, -4375, -3739, 2897, 8056, -5864, -522, 7451, -4541, -2813, 5790, -532, -6517, 925};
        long res = solve(arr);
        System.out.println(res);
    }
}
