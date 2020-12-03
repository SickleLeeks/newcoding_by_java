package com.jz.day1104;

public class HasPath_JZ {
    /**
     * 矩阵中的路径
     * 回溯法
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0 || "".equals(str)) {
            return false;
        }
        // 初始化一个标志位数组，未走过为false，走过为true
        boolean[] used = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (solve(matrix, i, j, rows, cols, used, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param matrix: 初始矩阵
     * @param i       : 行坐标索引
     * @param j       : 列坐标索引
     * @param rows    : 矩阵行数
     * @param cols    : 矩阵列数
     * @param used    : 标志数组
     * @param str     : 待判断的字符串
     * @param k       : 字符串索引初始为0，即先判断字符串第一位
     * @return
     */
    private static boolean solve(char[] matrix, int i, int j, int rows, int cols, boolean[] used, char[] str, int k) {
        // 先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i * cols + j;
        // 递归终止条件
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || used[index]) {
            return false;
        }
        // 如果k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if (k == str.length - 1) {
            return true;
        }
        // 要走的第一个位置置为true，表示已经走过了
        used[index] = true;
        // 回溯，递归寻找，每次找到了就给k加1，找不到，就还原
        if (solve(matrix, i - 1, j, rows, cols, used, str, k + 1) ||
                solve(matrix, i + 1, j, rows, cols, used, str, k + 1) ||
                solve(matrix, i, j - 1, rows, cols, used, str, k + 1) ||
                solve(matrix, i, j + 1, rows, cols, used, str, k + 1)) {
            return true;
        }
        // 走到这里，说明这一条路不通，还原，再尝试其他路径
        used[index] = false;
        return false;
    }

    public static void main(String[] args) {
        char[] matrix = new char[]{
                'a', 'b', 'c', 'e',
                's', 'f', 'c', 's',
                'a', 'd', 'e', 'e',
        };
        int rows = 3;
        int cols = 4;
        char[] str = "bcced".toCharArray();
        System.out.println(hasPath(matrix, rows, cols, str));
    }
}
