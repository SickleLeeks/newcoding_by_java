package com.nc.day1028;

import java.util.Arrays;

/**
 * 数独问题
 */
public class Sudoku_Solution {
    /**
     * 循环处理子问题，对于每个格子，带入不同的9个数，然后判断合法性，如果成立就递归继续，结束后把数字重置为'.'
     *
     * @param board
     */
    public static void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        // 递归到最后一步，所有空位都填满
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char k) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == k) {
                return false;
            }
            if (board[row][i] == k) {
                return false;
            }
        }
        // 判断所属的3x3单元格内是否重复
        int xBegin = (row / 3) * 3;
        int yBegin = (col / 3) * 3;
        for (int i = xBegin; i < xBegin + 3; i++) {
            for (int j = yBegin; j < yBegin + 3; j++) {
                if (board[i][j] == k) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
