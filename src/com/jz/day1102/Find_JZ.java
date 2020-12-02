package com.jz.day1102;

public class Find_JZ {
    /**
     * 二维数组中的查找
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        int m = array.length;
        int n = array[0].length;
        if (target < array[0][0] || target > array[m - 1][n - 1]) {
            return false;
        }
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (array[row][col] > target) {
                col--;
            } else if (array[row][col] < target) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }
}
