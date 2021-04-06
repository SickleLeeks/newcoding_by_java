package com.jz.day1117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 牛客网：括号序列
 */
public class IsValid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean flag = isValid(str);
        System.out.println(flag);
    }

    /**
     * 使用栈
     * @param s string字符串
     * @return bool布尔型
     */
    public static boolean isValid(String s) {
        // write code here
        if (s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> c = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (c.isEmpty()) {
                c.push(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == ')' && c.peek() == '(') {
                c.pop();
            } else if (s.charAt(i) == ']' && c.peek() == '[') {
                c.pop();
            } else if (s.charAt(i) == '}' && c.peek() == '{') {
                c.pop();
            } else {
                c.push(s.charAt(i));
            }
        }
        return c.empty();
    }
}
