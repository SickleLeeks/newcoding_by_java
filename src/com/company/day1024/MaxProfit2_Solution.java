package com.company.day1024;

/**
 * 股票交易的最大收益2
 */
public class MaxProfit2_Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 两次交易所能获得的最大收益
     *
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{8, 9, 3, 5, 1, 3};
        System.out.println(maxProfit(prices));
    }
}
