package com.company.day1001;

import java.util.LinkedList;

public class Island_Solution {
    /* 并查集方法
     * 1. 初始化并查集，用record[i*col+j]重新表示grid[i][j]节点
     * 2.
     */

    public static class UnionFind {
        private int[] records;

        public UnionFind(int n) {
            records = new int[n];
            for (int i = 0; i < n; i++) {
                records[i] = i;
            }
        }

        //路径压缩，直接找到最大的老大赋值为直接上级
        public int find(int x) {
            int fx = x;
            while (records[fx] != fx) {
                fx = records[fx];
            }
            while (x != fx) {
                int tmp = records[x];
                records[x] = fx;
                x = tmp;
            }
            return fx;
        }

        public boolean union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                records[fx] = fy;
                return true;
            }
            return false;
        }
    }

    /**
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public static int solve1(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        UnionFind unionFind = new UnionFind(row * col);
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    if (i + 1 < row && grid[i + 1][j] == '1' && unionFind.union(i * col + j, (i + 1) * col + j)) {
                        count--;
                    }
                    if (j + 1 < col && grid[i][j + 1] == '1' && unionFind.union(i * col + j, i * col + (j + 1))) {
                        count--;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 岛屿问题，bfs解法
     * 1. 队列中保存矩阵中值为1的坐标，通过BFS搜索附近四周同属于一个岛的所有坐标，并置为0，防止后续操作重复计算
     * 2. 搜索一次发现一座岛屿计数+1
     * @param grid
     * @return
     */
    public static int solve2(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    LinkedList<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0';
                    bfs(queue, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(LinkedList<int[]> queue, char[][] grid) {
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                queue.offer(new int[]{x - 1, y});
                grid[x - 1][y] = '0';
            }
            if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                queue.offer(new int[]{x, y - 1});
                grid[x][y - 1] = '0';
            }
            if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                queue.offer(new int[]{x + 1, y});
                grid[x + 1][y] = '0';
            }
            if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                queue.offer(new int[]{x, y + 1});
                grid[x][y + 1] = '0';
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '1', '1'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '1', '1', '1'}
        };
        System.out.println(Island_Solution.solve1(grid));
        System.out.println(solve2(grid));
    }
}
