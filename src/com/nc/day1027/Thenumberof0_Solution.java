package com.nc.day1027;

/**
 * n的阶乘末尾含0的个数
 */
public class Thenumberof0_Solution {
    /**
     * the number of 0
     *
     * @param n long长整型 the number
     * @return long长整型
     */
    public static long thenumberof0(long n) {
        long res = 0;
        long i = 5;
        while (i<=n){
            res+=n/i;
            i*=5;
        }
        return res;
    }


    public static void main(String[] args) {
        long n = 5;
        System.out.println(thenumberof0(n));
    }
}
