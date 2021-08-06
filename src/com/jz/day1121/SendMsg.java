package com.jz.day1121;

import java.util.*;

/**
 * Leetcode LCP 07 传递消息
 *
 */
public class SendMsg {
    public static int ways, n, k;
    public static List<List<Integer>> edges;

    public static void main(String[] args) {
        n = 5;
        k = 3;
        int[][] matrix = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
//        ways = numWays1(n, matrix, k);// 深度优先
//        ways = numWays2(n, matrix, k);// 广度优先
//        ways = numWays3(n, matrix, k); //动态规划
        ways = numWays4(n, matrix, k); //动态规划优化
        System.out.println(ways);
    }

    //动态规划优化
    public static int numWays4(int n, int[][] relation, int k) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            int[] next = new int[n];
            for (int[] edge : relation) {
                int src = edge[0], dest = edge[1];
                next[dest] += dp[src];
            }
            dp = next;
        }
        return dp[n - 1];
    }

    //动态规划
    public static int numWays3(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dest = edge[1];
                dp[i + 1][dest] += dp[i][src];
            }
        }
        return dp[k][n - 1];
    }

    // 广度优先
    public static int numWays2(int n, int[][] relation, int k) {
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dest = edge[1];
            edges.get(src).add(dest);
        }
        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty() && steps < k) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                List<Integer> list = edges.get(index);
                for (int nextIndex : list) {
                    queue.offer(nextIndex);
                }
            }
        }
        ways = 0;
        if (steps == k) {
            while (!queue.isEmpty()) {
                if (queue.poll() == n - 1) {
                    ways++;
                }
            }
        }
        return ways;
    }

    public static int numWays1(int n, int[][] relation, int k) {
        ways = 0;
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dest = edge[1];
            edges.get(src).add(dest);
        }
        dfs(0, 0);
        return ways;
    }

    // 深度优先搜索
    private static void dfs(int index, int steps) {
        if (steps == k) {
            if (index == n - 1) {
                ways++;
            }
            return;
        }
        List<Integer> list = edges.get(index);
        for (int nextIndex : list) {
            dfs(nextIndex, steps + 1);
        }
    }
}
