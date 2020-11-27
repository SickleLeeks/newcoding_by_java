package com.nc.day1003;

public class SearchMatrix_Solution {
    /**
     * @param matrix int整型二维数组
     * @param target int整型
     * @return bool布尔型
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int i = 0, j = n;
        while (i <= m && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 9}, {10, 11, 12, 30}, {230, 300, 350, 500}};
        int target = 40;
        System.out.println(searchMatrix(matrix, target));
    }
}
