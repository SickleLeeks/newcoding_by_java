package com.play.day1208;

public class CountWine {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回牛牛能喝的最多的酒
     *
     * @param m int整型 酒单价
     * @param n int整型 牛牛的现金
     * @return int整型
     */
    public static int countWine(int m, int n) {
        if (n < m) {
            return 0;
        }
        int count = 0;
        int
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 12;
        System.out.println(countWine(m, n));
    }
}
