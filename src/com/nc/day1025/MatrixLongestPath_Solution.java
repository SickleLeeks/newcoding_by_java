package com.nc.day1025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MatrixLongestPath_Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 递增路径的最大长度
     *
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    static int[][] dp;
    static int[] dirs = new int[]{0, 1, 0, -1, 0};// 控制方向
    static int m, n;

    public static int solve(int[][] matrix) {
        int max = 1;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    private static int dfs(int[][] matrix, int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;
        for (int k = 0; k < 4; k++) {
            int nx = x + dirs[k];
            int ny = y + dirs[k + 1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] < matrix[x][y]) {
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(matrix, nx, ny));
            }
        }
        return dp[x][y];
    }

    public static int mysolve(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        Stack<int[]> maxStack = new Stack<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == max) {
                    maxStack.push(new int[]{i, j});
                }
            }
        }
        int res = Integer.MIN_VALUE;
        while (!maxStack.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int[] point = maxStack.pop();
            int row = point[0];
            int col = point[1];
            boolean[][] used = new boolean[m][n];
            used[row][col] = true;
            list.add(matrix[row][col]);
            while (true) {
                int top = (row - 1 >= 0 && used[row - 1][col] == false) ? matrix[row][col] - matrix[row - 1][col] : Integer.MAX_VALUE;
                int down = (row + 1 < m && used[row + 1][col] == false) ? matrix[row][col] - matrix[row + 1][col] : Integer.MAX_VALUE;
                int left = (col - 1 >= 0 && used[row][col - 1] == false) ? matrix[row][col] - matrix[row][col - 1] : Integer.MAX_VALUE;
                int right = (col + 1 < n && used[row][col + 1] == false) ? matrix[row][col] - matrix[row][col + 1] : Integer.MAX_VALUE;
                int min = Integer.MAX_VALUE, index = 0;
                int[] dirs = new int[]{top, down, left, right};
                for (int i = 0; i < dirs.length; i++) {
                    if (dirs[i] >= 0 && dirs[i] < min) {
                        min = dirs[i];
                        index = i;
                    }
                }
                if (min == Integer.MAX_VALUE) {
                    break;
                } else {
                    switch (index) {
                        case 0:
                            row = row - 1;
                            list.add(matrix[row][col]);
                            used[row][col] = true;
                            break;
                        case 1:
                            row = row + 1;
                            list.add(matrix[row][col]);
                            used[row][col] = true;
                            break;
                        case 2:
                            col = col - 1;
                            list.add(matrix[row][col]);
                            used[row][col] = true;
                            break;
                        case 3:
                            col = col + 1;
                            list.add(matrix[row][col]);
                            used[row][col] = true;
                            break;
                        default:
                            break;
                    }
                }
            }
            if (list.size() > res) {
                res = list.size();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = new int[][]{{1, 2}, {4, 3}};
        System.out.println(solve(matrix));
    }
}
