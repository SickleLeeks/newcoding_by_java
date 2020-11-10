package com.company.day1024;

/**
 * 股票交易的最大收益
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
        if (prices==null||prices.length<=1){
            return 0;
        }

    }

    public static void main(String[] args) {
        int[] prices = new int[]{8, 9, 3, 5, 1, 3};
        System.out.println(maxProfit(prices));
    }
}
