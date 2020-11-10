package com.company.day1024;

public class MaxProfit_Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算最大收益
     * 只买卖一次， 动态规划
     *
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        //定义前i日的最小值
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    // 只买卖一次，动态规划标准写法
    public static int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }
        return dp[prices.length - 1];
    }

    /**
     * 买卖多次，将数组拆分为升序子数组
     *
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int start = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                max = max + (prices[i - 1] - prices[start]);
                start = i;
            }
        }
        return max + prices[prices.length - 1] - prices[start];
    }

    public static void main(String[] args) {
        int[] num = new int[]{2, 4, 10, 57, 30, 82, 90, 12, 5, 13}; // 123
        System.out.println(maxProfit3(num));
    }
}
