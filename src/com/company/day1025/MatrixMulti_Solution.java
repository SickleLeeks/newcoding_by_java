package com.company.day1025;

import java.util.Arrays;

public class MatrixMulti_Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a int整型二维数组 第一个矩阵
     * @param b int整型二维数组 第二个矩阵
     * @return int整型二维数组
     */
    public static int[][] solve(int[][] a, int[][] b) {
        int[][] res = new int[a.length][b[0].length];
        if (a[0].length != b.length) {
            return res;
        }
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                int k = 0, sum = 0;
                while (k < b.length) {
                    sum += a[i][k] * b[k][j];
                    k++;
                }
                res[i][j] = sum;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat1 = new int[][]{{1, 2}, {3, 2}};
        int[][] mat2 = new int[][]{{3, 4}, {2, 1}};
        int[][] res = solve(mat1,mat2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
