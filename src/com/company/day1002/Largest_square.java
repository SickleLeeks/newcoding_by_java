package com.company.day1002;

/**
 * @author PANG
 */
public class Largest_square {
    /**
     * 最大正方形
     *
     * @param matrix char字符型二维数组
     * @return int整型
     */
    public static int solve(char[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                } else if (dp[i - 1][j - 1] != 0 && matrix[i][j] == '1' && matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1') {
                    int len = (int) Math.sqrt(dp[i - 1][j - 1]) + 1;
                    int row = 0, col = 0;
                    for (int k = i - len + 1; k <= i; k++) {
                        if (matrix[k][j] == '1') {
                            row += 1;
                        }
                    }
                    for (int k = j - len + 1; k <= j; k++) {
                        if (matrix[j][k] == '1') {
                            col += 1;
                        }
                    }
                    if (row == len && col == len) {
                        dp[i][j] = (int) Math.pow(len, 2);
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static int solve2(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else if (dp[i - 1][j - 1] != 0 && matrix[i][j] == 1 && matrix[i - 1][j] == 1 && matrix[i][j - 1] == 1) {
                    int len = (int) Math.sqrt(dp[i - 1][j - 1]) + 1;
                    int row = 0, col = 0;
                    for (int k = i - len + 1; k <= i; k++) {
                        if (matrix[k][j] == 1) {
                            row += 1;
                        }
                    }
                    for (int k = j - len + 1; k <= j; k++) {
                        if (matrix[j][k] == 1) {
                            col += 1;
                        }
                    }
                    if (row == len && col == len) {
                        dp[i][j] = (int) Math.pow(len, 2);
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    dp[i][j] = matrix[i][j] == 1 ? 1 : 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] mat = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int[][] mat2 = new int[][]{
                {1, 0, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 1, 1, 0, 1, 1, 0, 0, 0}
        };
        System.out.println(solve(mat));
        System.out.println(solve2(mat2));
    }
}
