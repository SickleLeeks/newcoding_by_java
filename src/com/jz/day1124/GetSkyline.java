package com.jz.day1124;

import java.util.*;

/**
 * Leetcode 218 天际线问题
 * 没写出来
 */
public class GetSkyline {
    public static void main(String[] args) {
        int[][] building = new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<List<Integer>> res = getSkyline(building);
        System.out.println(res.toString());
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        List<Integer> boundaries = new ArrayList<>();
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        Collections.sort(boundaries);
        List<List<Integer>> res = new ArrayList<>();
        int n = buildings.length, idx = 0;
        for (int boundary : boundaries) {
            while (idx < n && buildings[idx][0] <= boundary) {
                priorityQueue.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            while (!priorityQueue.isEmpty() && priorityQueue.peek()[0] <= boundary) {
                priorityQueue.poll();
            }
            int maxn = priorityQueue.isEmpty() ? 0 : priorityQueue.peek()[1];
            if (res.size() == 0 || maxn != res.get(res.size() - 1).get(1)) {
                res.add(Arrays.asList(boundary, maxn));
            }
        }
        return res;
    }
}
