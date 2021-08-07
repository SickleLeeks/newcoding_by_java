package com.jz.day1128;

import java.util.Arrays;

/**
 * 743. 网络延迟时间
 */
public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] graph = new int[n][n];// 邻接矩阵存储边信息
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF); // 初始化
        }
        for (int[] time : times) {
            int x = time[0] - 1;// 出发点
            int y = time[1] - 1;// 到达点
            graph[x][y] = time[2];// 边权值
        }
        int[] dist = new int[n]; // 定义从源点到终点的距离数组
        Arrays.fill(dist, INF);
        // 由于从点k开始，因此，该点的距离为0
        dist[k - 1] = 0;

        boolean[] used = new boolean[n];// 定义节点是否完全确定
        for (int i = 0; i < n; i++) {
            // 在还未确定的最短路的点中，寻找距离最小的点
            int x = -1;
            for (int y = 0; y < n; y++) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            // 用该点更新所有其他点的距离
            used[x] = true;
            for (int y = 0; y < n; y++) {
                dist[y] = Math.min(dist[y], dist[x] + graph[x][y]);
            }
        }
        int res = Arrays.stream(dist).max().getAsInt();
        return res == INF ? -1 : res;
    }
}
