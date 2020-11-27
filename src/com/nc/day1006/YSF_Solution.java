package com.nc.day1006;

public class YSF_Solution {
    /**
     * 约瑟夫环问题
     * 1. 假设一开始n个人的编号为0...n-1
     * 2. 把第k个人(编号为k-1)杀死之后，队伍的编号变成了k，k+1,k+2,...,n-2,n-1,0,1...;从第k个人重复上述过程
     * 3. 将上面的每个人编号都减去k，编号变成了0，1，2,...,n-3,n-2；即变成了一个n-1阶的约瑟夫问题
     * 4. n-1阶约瑟夫问题+k就得到n阶约瑟夫问题的解，那么n-1阶约瑟夫问题的解从n-2阶约瑟夫问题那里得到，于是得到一个O(n)的递推过程
     * 5. 得到n阶约瑟夫问题的解之后，还要+1,因为是从0开始编号的。
     *
     * @param n int整型
     * @param m int整型
     * @return int整型
     */
    public static int ysf(int n, int m) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = (res + m) % i;
        }
        return res + 1;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 2;
        System.out.println(ysf(n, m));
    }
}
