package com.jz.day1101;

import java.util.Arrays;

public class Multiply_JZ {
    /**
     * 构建乘积数组
     *
     * @param A
     * @return
     */
    public static int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(multiply(A)));
    }
}
