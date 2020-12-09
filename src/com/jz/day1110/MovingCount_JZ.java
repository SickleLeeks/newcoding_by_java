package com.jz.day1110;

public class MovingCount_JZ {
    /**
     * 机器人的运动范围
     *
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    static int count = 0;

    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold == 0 || rows == 0 || cols == 0) {
            return 0;
        }
        boolean[][] isused = new boolean[rows][cols];
        solve(0, 0, threshold, rows, cols, isused);
        return count;
    }

    private static void solve(int row, int col, int threshold, int rows, int cols, boolean[][] isused) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }
        if (isused[row][col] == true) {
            return;
        }
        if (!isValid(row, col, threshold)) {
            isused[row][col] = true;
            return;
        }
        isused[row][col] = true;
        count++;
        solve(row + 1, col, threshold, rows, cols, isused);
        solve(row, col + 1, threshold, rows, cols, isused);
    }

    private static boolean isValid(int row, int col, int threshold) {
        String[] num1 = String.valueOf(row).split("");
        String[] num2 = String.valueOf(col).split("");
        int temp = 0;
        for (int k = 0; k < num1.length; k++) {
            temp += Integer.parseInt(num1[k]);
        }
        for (int k = 0; k < num2.length; k++) {
            temp += Integer.parseInt(num2[k]);
        }
        if (temp <= threshold) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int threshold = 15;
        int rows = 20;
        int cols = 20;
        System.out.println(movingCount(threshold, rows, cols));
    }
}
