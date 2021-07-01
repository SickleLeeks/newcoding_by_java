package com.jz.day1120;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 边界都是1的最大正方形大小
 */
public class MaxTangleSize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine().trim());
        int[][] mat = new int[N][N];
        for (int i = 0; i < N; i++) {
            mat[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int res = solution(mat);
        System.out.println(res);
    }

    private static int solution(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        // right[i][j]表示m[i][j]的右边有多少个连续的1，包括自身
        int[][] right = new int[mat.length][mat[0].length];
        // down[i][j]表示m[i][j]的下边有多少个连续的1，包括自身
        int[][] down = new int[mat.length][mat[0].length];
        int nrow = mat.length;
        int ncol = mat[0].length;
        // 初始化右下角的位置
        right[nrow - 1][ncol - 1] = mat[nrow - 1][ncol - 1];
        down[nrow - 1][ncol - 1] = mat[nrow - 1][ncol - 1];
        // 初始化最后一行, 对列从右到左遍历
        for (int i = ncol - 2; i >= 0; i--) {
            if (mat[nrow - 1][i] == 1) {
                right[nrow - 1][i] = right[nrow - 1][i + 1] + 1;
                down[nrow - 1][i] = 1;
            }
        }
        // 初始化最后一列，对行从下到上遍历
        for (int i = nrow - 2; i >= 0; i--) {
            if (mat[i][ncol - 1] == 1) {
                right[i][ncol - 1] = 1;
                down[i][ncol - 1] = down[i + 1][ncol - 1] + 1;
            }
        }
        // 对于其他位置，从右向左，从下到上填充
        for (int i = nrow - 2; i >= 0; i--) {
            for (int j = ncol - 2; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    right[i][j] = right[i][j + 1] + 1;
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }
        // 以正方形边长为索引，从大到小依此遍历
        for (int length = Math.min(nrow, ncol); length >= 1; length--) {
            // 对于每个大小的边长，看是否存在以该值为边长的矩阵，满足四周都是1, 那么如果边长为length，则
            // (irow,icol)表示矩阵的左上角，要想满足正方形的条件，则要求在该点的右边(right矩阵)最少有连续的length个1，在该点的下边(down矩阵)最少有连续的length个1
            // (irow+length-1,icol) 表示矩阵的左下角， 要求在该点的右边(right矩阵)最少有连续的length个1
            // (irow, icol+length-1) 表示矩阵的右上角，要求在该点的下边(down矩阵)最少有连续的length个1
            // 因此，上述四个条件都满足，则构成一个正方形，返回
            for (int irow = 0; irow + length - 1 <= right.length - 1; irow++) {
                for (int icol = 0; icol + length - 1 <= down[0].length - 1; icol++) {
                    if (right[irow][icol] >= length && down[irow][icol] >= length && right[irow + length - 1][icol] >= length && down[irow][icol + length - 1] >= length) {
                        return length;
                    }
                }
            }
        }
        return 0;
    }
}
