package com.nc.day1023;

public class MinPathSum_Solution {
    /**
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public static int minPathSum(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                } else if (i == 0) {
                    dp[i][j] = matrix[i][j] + dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = matrix[i][j] + dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + matrix[i][j], dp[i][j - 1] + matrix[i][j]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(minPathSum(mat));
    }
}
