package com.company.day1022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author epngxnz
 */
public class StackAndSort_Solution {

    /**
     * 栈排序
     *
     * @param a int整型一维数组 描述入栈顺序
     * @return int整型一维数组
     */
    public static int[] solve(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int index = 0, n = a.length;
        int Max = Integer.MIN_VALUE;
        int[][] maxarr = new int[n][2];
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] > Max) {
                Max = a[i];
                index = i;
            }
            maxarr[i][0] = Max;
            maxarr[i][1] = index;
        }
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stack.push(a[i]);
            if (maxarr[i][1] == i) {
                list.add(stack.pop());
                while (!stack.isEmpty() && i < n - 1 && stack.peek() > maxarr[i + 1][0]) {
                    list.add(stack.pop());
                }
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        int[] res = new int[a.length];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 2, 4};
        System.out.println(Arrays.toString(solve(arr)));
    }
}
