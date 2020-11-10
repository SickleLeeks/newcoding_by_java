package com.company.day1021;

import java.util.ArrayList;
import java.util.Iterator;

public class GenerateParenthesis_Solution {
    /**
     * 括号生成：回溯法
     * 记录左括号和右括号的数量
     * 当左括号数量小于n时继续添加左括号
     * 当右括号数量小于左括号时继续添加右括号
     *
     * @param n int整型
     * @return string字符串ArrayList
     */
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        backtrack("", 0, 0, n, list);
        return list;
    }

    private static void backtrack(String str, int open, int close, int n, ArrayList<String> list) {
        // 字符串的长度最多为n*2，即n<<1
        if (str.length() == n << 1) {
            list.add(str);
            return;
        }
        if (open < n) {
            backtrack(str + "(", open + 1, close, n, list);
        }
        if (close < open) {
            backtrack(str + ")", open, close + 1, n, list);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        ArrayList<String> res = generateParenthesis(n);
        Iterator i = res.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
