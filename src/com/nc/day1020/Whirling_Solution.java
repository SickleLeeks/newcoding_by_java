package com.nc.day1020;

public class Whirling_Solution {
    /**
     * 旋转字符串
     *
     * @param A string字符串
     * @param B string字符串
     * @return bool布尔型
     */
    public static boolean solve(String A, String B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null ^ B == null) {
            return false;
        }
        if (A.length() != B.length()) {
            return false;
        }
        for (int i = 1; i < A.length(); i++) {
            String tmp1 = A.substring(0, i);
            String tmp2 = A.substring(i);
            if ((tmp2 + tmp1).equals(B)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String A = "zhanyou";
        String B = "youzhan";
        System.out.println(solve(A, B));
    }
}
