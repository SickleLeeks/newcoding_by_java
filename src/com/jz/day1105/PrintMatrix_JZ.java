package com.jz.day1105;

import java.util.ArrayList;

public class PrintMatrix_JZ {
    /**
     * 顺时针打印矩阵
     *
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int i = 0, j = 0;

        if (row == 0) {
            for (int k = j; k <= col; k++) {
                res.add(matrix[0][k]);
            }
            return res;
        } else if (col == 0) {
            for (int k = i; k <= row; k++) {
                res.add(matrix[k][0]);
            }
            return res;
        } else {
            while (i <= row && j <= col) {
                if (i <= row) {
                    for (int k = j; k <= col; k++) {
                        res.add(matrix[i][k]);
                    }
                    i++;
                }
                if (j <= col) {
                    for (int k = i; k <= row; k++) {
                        res.add(matrix[k][col]);
                    }
                    col--;
                }
                if (i <= row) {
                    for (int k = col; k >= j; k--) {
                        res.add(matrix[row][k]);
                    }
                    row--;
                }
                if (j <= col) {
                    for (int k = row; k >= i; k--) {
                        res.add(matrix[k][j]);
                    }
                    j++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };
        System.out.println(printMatrix(matrix));
    }
}
