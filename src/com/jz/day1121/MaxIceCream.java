package com.jz.day1121;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Leetcode1833 雪糕的最大数量
 */
public class MaxIceCream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coins = Integer.parseInt(sc.nextLine());
        int[] costs = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int res = maxIceCream2(costs, coins);
        System.out.println(res);
    }

    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        int n = costs.length;
        for (int i = 0; i < n; i++) {
            int cost = costs[i];
            if (coins >= cost) {
                coins -= cost;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    //计数排序+贪心
    public static int maxIceCream2(int[] costs, int coins) {
        int[] freq = new int[100001];// n的最大数量
        //下标即雪糕的价格，下标的值表示数量
        for (int i : costs) {
            freq[i]++;
        }
        int count = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                // 最多可以购买的数量
                int currCount = Math.min(freq[i], coins / i);
                count += currCount;
                coins -= i * currCount;
            } else {
                break;
            }
        }
        return count;
    }

}
