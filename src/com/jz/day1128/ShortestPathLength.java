package com.jz.day1128;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 847. 访问所有节点的最短路径
 * HARD
 */
public class ShortestPathLength {
    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3}, {0}, {0}, {0}};
        System.out.println(shortestPathLength(graph));
    }

    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            if (mask == (1 << n) - 1) {
                res = dist;
                break;
            }
            // 搜索相邻的节点
            for (int v : graph[u]) {
                // 将mask的第v个位置标记为1
                int maskV = mask | (1 << v);
                if (!seen[v][maskV]) {
                    queue.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return res;
    }
}
