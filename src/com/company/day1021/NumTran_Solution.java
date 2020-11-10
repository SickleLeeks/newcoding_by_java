package com.company.day1021;

import java.util.Stack;

public class NumTran_Solution {
    /**
     * 进制转换
     *
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public static String solve(int M, int N) {
        Stack<String> stack = new Stack<>();
        boolean flag = false;
        if (M < 0) {
            flag = true;
            M = Math.abs(M);
        }
        while (M / N != 0) {
            int tmp = M % N;
            if (tmp == 10) {
                stack.push("A");
            } else if (tmp == 11) {
                stack.push("B");
            } else if (tmp == 12) {
                stack.push("C");
            } else if (tmp == 13) {
                stack.push("D");
            } else if (tmp == 14) {
                stack.push("E");
            } else if (tmp == 15) {
                stack.push("F");
            } else {
                stack.push(String.valueOf(tmp));
            }
            M = M / N;
        }
        stack.push(String.valueOf(M));
        StringBuilder res = new StringBuilder();
        if (flag) {
            res.append("-");
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int M = -4;
        int N = 3;
        System.out.println(solve(M, N));
    }
}
