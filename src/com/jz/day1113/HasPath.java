package com.jz.day1113;

import java.util.ArrayList;

/**
 * 剑指offer: 矩阵中的路径
 */
public class HasPath {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'a', 'b', 'c'}, {'b', 'e', 'd'}, {'f', 'g', 'g'}};
        String word = "abcdebf";
        boolean res = hasPath(matrix, word);
        System.out.println(res);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 利用递归特性实现DFS的回溯
     * @param matrix char字符型二维数组
     * @param word   string字符串
     * @return bool布尔型
     */
    public static boolean hasPath(char[][] matrix, String word) {
        // write code here
        int nrow = matrix.length;
        if (nrow == 0) {
            return false;
        }
        int ncol = matrix[0].length;
        boolean[][] visited = new boolean[nrow][ncol];
        for (int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                if (findPath(matrix, i, j, visited, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findPath(char[][] matrix, int irow, int icol, boolean[][] visited, String word, int loc) {
        if (loc == word.length()) {
            return true;
        }
        if (irow < 0 || irow == matrix.length || icol < 0 || icol == matrix[0].length) {
            return false;
        }
        if (visited[irow][icol]) {
            return false;
        }
        if (matrix[irow][icol] == word.charAt(loc)) {
            visited[irow][icol] = true;
            if (findPath(matrix, irow - 1, icol, visited, word, loc + 1)
                    || findPath(matrix, irow + 1, icol, visited, word, loc + 1)
                    || findPath(matrix, irow, icol - 1, visited, word, loc + 1)
                    || findPath(matrix, irow, icol + 1, visited, word, loc + 1)) {
                return true;
            }
            visited[irow][icol] = false;
        }
        return false;
    }
}
