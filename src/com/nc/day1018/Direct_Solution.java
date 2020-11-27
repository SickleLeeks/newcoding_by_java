package com.nc.day1018;

import com.nc.util.Interval;

import java.util.ArrayList;

public class Direct_Solution {
    private static int res = 0;

    /**
     * 树的直径
     *
     * @param n          int整型 树的节点个数
     * @param Tree_edge  Interval类一维数组 树的边
     * @param Edge_value int整型一维数组 边的权值
     * @return int整型
     */
    public static int solve(int n, Interval[] Tree_edge, int[] Edge_value) {
        ArrayList[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < Tree_edge.length; i++) {
            map[Tree_edge[i].start].add(new int[]{Tree_edge[i].end, Edge_value[i]});
            map[Tree_edge[i].end].add(new int[]{Tree_edge[i].start, Edge_value[i]});
        }
        dfs(map, 0, new boolean[n]);
        return res;
    }

    private static int dfs(ArrayList[] map, int index, boolean[] visited) {
        visited[index] = true;
        ArrayList<int[]> list = map[index];
        int weight1 = 0, weight2 = 0;
        for (int[] child2weight : list) {
            int child = child2weight[0];
            int weight = child2weight[1];
            if (visited[child]) {
                continue;
            }
            int num = weight + dfs(map, child, visited);
            if (num > weight1) {
                weight2 = weight1;
                weight1 = num;
            } else if (num > weight2) {
                weight2 = num;
            }
            if (weight1 + weight2 > res) {
                res = weight1 + weight2;
            }
        }
        return Math.max(weight1, weight2);
    }

    public static void main(String[] args) {
        int num = 6;
        Interval[] intervals = new Interval[]{new Interval(0, 1), new Interval(1, 5), new Interval(1, 2), new Interval(2, 3), new Interval(2, 4)};
        int[] values = new int[]{3, 4, 2, 1, 5};
        int res = solve(num, intervals, values);
        System.out.println(res);
    }
}
