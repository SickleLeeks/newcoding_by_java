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
        int numPing, numGai;
        numPing = numGai = n / m;
        count += numPing;
        while (numPing >= 2 || numGai >= 4) {
            if (numPing >= 2) {
                int temp1 = numPing / 2;
                int temp2 = numPing % 2;
                numPing = temp1 + temp2;
                numGai = numGai + temp1;
                count += temp1;
            }
            if (numGai >= 4) {
                int temp1 = numGai / 4;
                int temp2 = numGai % 4;
                numPing = numPing + temp1;
                numGai = temp1 + temp2;
                count += temp1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 2;
        int n = 12;
        System.out.println(countWine(m, n));
    }
}
