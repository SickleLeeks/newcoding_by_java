package com.company.day1010;

import java.util.Arrays;

/**
 * 转圈打印矩阵
 */
public class CyclePring_Solution {
    /**
     * @param matrix int整型二维数组 the matrix
     * @return int整型一维数组
     */
    public static int[] printMatrix(int[][] matrix) {
        // write code here
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{0};
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int rowStart = 0;
        int colStart = 0;
        int rowEnd = matrix.length - 1;
        int colEnd = matrix[0].length - 1;
        int index = 0;
        if (matrix.length == 1) {
            for (int i = colStart; i < colEnd; i++) {
                res[index++] = matrix[0][colStart];
            }
        }
        if (matrix[0].length == 1) {
            for (int i = rowStart; i < rowEnd; i++) {
                res[index++] = matrix[rowStart][0];
            }
        }
        while (rowStart <= rowEnd && colStart <= colEnd) {
            // 从左往右
            for (int i = colStart; i <= colEnd && rowStart <= rowEnd; i++) {
                res[index++] = matrix[rowStart][i];
            }
            rowStart++;
            // 从上往下
            for (int i = rowStart; i <= rowEnd && colStart <= colEnd; i++) {
                res[index++] = matrix[i][colEnd];
            }
            colEnd--;
            // 从右往左
            for (int i = colEnd; i >= colStart && rowStart <= rowEnd; i--) {
                res[index++] = matrix[rowEnd][i];
            }
            rowEnd--;
            // 从下往上
            for (int i = rowEnd; i >= rowStart && colStart <=colEnd; i--) {
                res[index++] = matrix[i][colStart];
            }
            colStart++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{
                1, 2, 3, 4
        }, {
                5, 6, 7, 8
        }, {
                9, 10, 11, 12
        }, {
                13, 14, 15, 16
        }};
        int[] res = printMatrix(mat);
        System.out.println(Arrays.toString(res));
    }
}
