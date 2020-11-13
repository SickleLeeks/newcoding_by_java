package com.company.day1024;

import java.util.Arrays;

public class FindElement_Solution {
    public static int[] findElement(int[][] mat, int n, int m, int x) {
        int[] res = new int[2];
        if (mat == null || x < mat[0][0] || x > mat[n-1][m-1]) {
            return res;
        }
        int row = 0;
        int col = m-1;
        while (row < n && col >= 0) {
            if (x > mat[row][col]) {
                row++;
            } else if (x < mat[row][col]) {
                col--;
            } else {
                res[0] = row;
                res[1] = col;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int n = 3;
        int m = 3;
        int x = 6;
        System.out.println(Arrays.toString(findElement(mat, n, m, x)));
    }
}
