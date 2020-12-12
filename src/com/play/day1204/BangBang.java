package com.play.day1204;

/**
 * 音符选取
 */
public class BangBang {
    /**
     * @param n int整型 乐谱总音符数
     * @param m int整型 重音符数
     * @param k int整型 重音符之间至少的间隔
     * @return long长整型
     */
    public static long solve_bangbang(int n, int m, int k) {
        if (n == 0 || m > n || k >= n) {
            return 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        int k = 1;
        System.out.println(solve_bangbang(n, m, k));
    }
}
