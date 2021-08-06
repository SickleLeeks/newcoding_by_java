package com.jz.day1126;

import java.util.*;

/**
 * 1743. 从相邻元素对还原数组
 */
public class RestoreArray {
    public static void main(String[] args) {
        int[][] adjacentPairs = new int[][]{{2, 1}, {3, 4}, {3, 2}};
        System.out.println(Arrays.toString(restoreArray(adjacentPairs)));
    }

    static Map<Integer, List<Integer>> adjMap = new HashMap<>();

    public static int[] restoreArray(int[][] adjacentPairs) {
        for (int[] pair : adjacentPairs) {
            int num1 = pair[0];
            int num2 = pair[1];
            updateAdjMap(num1, num2);
//            updateAdjMap(num2, num1);
        }
        int n = adjMap.keySet().size();
        int[] result = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : adjMap.entrySet()) {
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            if (adj.size() == 1) {
                result[0] = e;
                break;
            }
        }
        result[1] = adjMap.get(result[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> adj = adjMap.get(result[i - 1]);
            result[i] = result[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return result;
    }

    private static void updateAdjMap(int num1, int num2) {
//        if (adjMap.containsKey(num1)) {
//            List<Integer> temp = adjMap.get(num1);
//            if (!temp.contains(num2)) temp.add(num2);
//            adjMap.put(num1, temp);
//        } else {
//            List<Integer> temp = new ArrayList<>();
//            temp.add(num2);
//            adjMap.put(num1, temp);
//        }
        adjMap.putIfAbsent(num1, new ArrayList<>());
        adjMap.putIfAbsent(num2, new ArrayList<>());
        adjMap.get(num1).add(num2);
        adjMap.get(num2).add(num1);
    }
}
