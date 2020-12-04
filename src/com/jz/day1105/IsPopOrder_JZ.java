package com.jz.day1105;

import java.util.Stack;

public class IsPopOrder_JZ {
    /**
     * 栈的压入，弹出序列
     *
     * @param pushA
     * @param popA
     * @return
     */
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null && popA == null) {
            return true;
        } else if (pushA == null ^ popA == null) {
            return false;
        } else {
            Stack<Integer> stack = new Stack<>();
            int index = 0;
            for (int i = 0; i < popA.length; i++) {
                int temp = popA[i];
                while (index < pushA.length && (stack.isEmpty() || stack.peek() != temp)) {
                    stack.push(pushA[index]);
                    index++;
                }
                if (stack.peek() == temp) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 3, 5, 1, 2};
        System.out.println(IsPopOrder(pushA, popA));
    }
}
