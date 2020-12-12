package com.classical;

public class KnapStack01 {
    /**
     * 解决背包问题的递归函数
     *
     * @param w        物品的重量数组
     * @param v        物品的价值数组
     * @param index    当前待选择的物品索引
     * @param capacity 当前背包有效容量
     * @return 最大价值
     */
    private static int solveKS(int[] v, int index, int capacity) {
        //基准条件：如果索引无效或者容量不足，直接返回当前价值0
        if (index < 0 || capacity <= 0) {
            return 0;
        }
        //不放第index个物品所得价值
        int res = solveKS(v, index - 1, capacity);
        //放第index个物品所得价值（前提是：第index个物品可以放得下）
        if (v[index] <= capacity) {
            res = Math.max(res, v[index] + solveKS(v, index - 1, capacity - v[index]));
        }
        return res;
    }

    public static int knapSack(int n, int[] v, int C) {
        return solveKS(v, n - 1, C);
    }

    public static void main(String[] args) {
        int[] v = {84, 91, 28, 99, 14, 19, 84, 100, 4, 16};
        System.out.println(knapSack(10, v, 500));
    }
}
