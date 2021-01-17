package com.jz.day1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 */
public class StackToSort {
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(String.valueOf(br.readLine()));
        String[] line = br.readLine().split(" ");
        for (int i = N - 1; i >= 0; i--) {
            stack.push(Integer.parseInt(line[i]));
        }
        stacksort(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void stacksort(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            while (!help.isEmpty() && help.peek() < curr) {
                stack.push(help.pop());
            }
            help.push(curr);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
