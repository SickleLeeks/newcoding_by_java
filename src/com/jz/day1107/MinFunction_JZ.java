package com.jz.day1107;

import java.util.Stack;

public class MinFunction_JZ {
    /**
     * 包含min函数的栈
     */
    Stack<Integer> normal = new Stack<>();
    Stack<Integer> minstack = new Stack<>();

    public void push(int node) {
        normal.push(node);
        if (minstack.isEmpty()) {
            minstack.push(node);
        } else {
            if (node <= minstack.peek()) {
                minstack.push(node);
            } else {
                minstack.push(minstack.peek());
            }
        }
    }

    public void pop() {
        normal.pop();
        minstack.pop();
    }

    public int top() {
        return normal.peek();
    }

    public int min() {
        return minstack.peek();
    }
}
