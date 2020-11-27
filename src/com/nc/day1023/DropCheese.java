package com.nc.day1023;

// 丢棋子问题
public class DropCheese {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回最差情况下扔棋子的最小次数
     *
     * @param n int整型 楼层数
     * @param k int整型 棋子数
     * @return int整型
     */
    public static int solve(int n, int k) {
        if (n == 0 || k == 0) {
            return 0;
        }
        // k个棋子如果可以扔M次，最多可以解决多少楼层
        //N层楼完全用二分的方式扔logN+1次就直接可以确定哪层楼是会碎的最低层楼，如果棋子数大于logN+1,则返回logN+1
        int times = (int) (Math.log(n) / Math.log(2)) + 1;
        if (k >= times) {
            return times;
        }
        int res = 0;
        int[] dp = new int[k];
        while (true) {
            res++;
            int pre = 0;
            for (int i = 0; i < k; i++) {
                int tmp = dp[i];
                dp[i] = dp[i] + pre + 1;
                pre = tmp;
                if (dp[i] >= n) {
                    return res;
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 105;
        int K = 2;
        System.out.println(solve(N, K));
    }
}
