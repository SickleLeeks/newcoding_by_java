package com.company.day1015;

public class MaxProfit_Solution {
    /**
     * @param prices int整型一维数组
     * @return int整型
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
                if (i != j) {
                    max = Math.max(max, prices[j] - prices[i]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 4, 2};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
