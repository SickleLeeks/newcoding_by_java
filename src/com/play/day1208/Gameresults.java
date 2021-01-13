package com.play.day1208;

//分贝壳游戏
public class Gameresults {
    /**
     * @param n int整型
     * @param p int整型
     * @param q int整型
     * @return int整型
     */
    public static int Gameresults(int n, int p, int q) {
        // write code here
        if (p == q) {
            return n % (p + 1) != 0 ? 1 : -1;
        } else if (p > q) {
            return 1;
        } else {
            return n <= p ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int p = 3;
        int q = 3;
        System.out.println(Gameresults(n, p, q));
    }
}
