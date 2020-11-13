package com.company.day1024;

/**
 * 子数组的最大乘积
 */
public class MaxProduct_Solution {
    public static double maxProduct(double[] arr) {
        double min = arr[0];
        double max = min;
        double res = min;
        for (int i = 1; i < arr.length; i++) {
            double tmp = max;
            // 判断最小值与当前数值的乘积 和 最大值与当前数值的乘积 和当前数值 之间的大小
            max = Math.max(Math.max(arr[i], arr[i] * max), min * arr[i]);
            min = Math.min(Math.min(arr[i], arr[i] * min), tmp * arr[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        double[] dou = new double[]{-2.5, 4, 0, 3, 0.5, 8, -1};
        System.out.println(maxProduct(dou));
    }
}
