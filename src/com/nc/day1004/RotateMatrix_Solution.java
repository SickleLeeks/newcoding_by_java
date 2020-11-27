package com.nc.day1004;

import java.util.Arrays;

public class RotateMatrix_Solution {
    /**
     * 顺时针旋转数组
     *
     * @param mat
     * @param n
     * @return
     */
    public static int[][] rotateMatrix(int[][] mat, int n) {
        int[][] newmat = new int[n][n];
        if (mat==null||mat.length==0){
            return newmat;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newmat[j][n-i-1] = mat[i][j];
            }
        }
        return newmat;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = 3;
        System.out.println(Arrays.deepToString(rotateMatrix(mat, n)));
    }
}
