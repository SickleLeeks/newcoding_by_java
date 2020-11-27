package com.nc.day1014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class GetMinStack_Solution {
    /**
     * return a array which include all ans for op3
     *
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    public static int[] getMinStack(int[][] op) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < op.length; i++) {
            int k = op[i][0];
            if (k == 1) {
                int value = op[i][1];
                stack1.push(value);
            }
            if (k == 2) {
                stack1.pop();
            }
            if (k == 3) {
                if (!stack1.isEmpty()) {
                    int min = stack1.peek();
                    while (!stack1.isEmpty()) {
                        int top = stack1.pop();
                        if (top < min) {
                            min = top;
                        }
                        stack2.push(top);
                    }
                    list.add(min);
                    while (!stack2.isEmpty()) {
                        stack1.push(stack2.pop());
                    }
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] oper = new int[][]{{1, 3}, {1, 2}, {1, 1}, {3}, {2}, {3}};
        int[] res = getMinStack(oper);
        System.out.println(Arrays.toString(res));
    }
}
