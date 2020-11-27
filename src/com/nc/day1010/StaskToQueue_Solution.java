package com.nc.day1010;

import java.util.Stack;

/**
 * 用两个栈实现一个队列
 */
public class StaskToQueue_Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StaskToQueue_Solution staskToQueue = new StaskToQueue_Solution();
        staskToQueue.push(1);
        staskToQueue.push(2);
        System.out.println("出队元素： " + staskToQueue.pop());
        staskToQueue.push(3);
        staskToQueue.push(4);
        System.out.println("出队元素： " + staskToQueue.pop());
        System.out.println("出队元素： " + staskToQueue.pop());
        staskToQueue.push(5);
        System.out.println("出队元素： " + staskToQueue.pop());
        System.out.println("出队元素： " + staskToQueue.pop());
    }
}
