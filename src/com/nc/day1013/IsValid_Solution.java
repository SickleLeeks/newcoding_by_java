package com.nc.day1013;

import java.util.Stack;

public class IsValid_Solution {
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public static boolean isValid(String s) {
        // write code here
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == '}' && !stack.isEmpty() && stack.peek().equals('{')) {
                    stack.pop();
                } else if (s.charAt(i) == ']' && !stack.isEmpty() && stack.peek().equals('[')) {
                    stack.pop();
                } else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek().equals('(')) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        String str = "}(])[{(}([[}])}]))})]]({{(])";
        System.out.println(isValid(str));
    }
}
