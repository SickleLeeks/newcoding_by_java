package com.jz.day1103;

import java.util.ArrayList;
import java.util.Collections;

public class Permutation_JZ {
    /**
     * 字符串的排列
     *
     * @param str
     * @return
     */
    // 方法1
    static ArrayList<String> res = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {
        if (str == null || "".equals(str)) {
            return res;
        }
        solve(str, "");
        return res;
    }

    private static void solve(String str, String curr) {
        if (str.length() == 0) {
            if (!res.contains(curr)) {
                res.add(curr);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            solve(str.substring(0, i) + str.substring(i + 1), curr + str.charAt(i));
        }
    }


    // 方法2:回溯法
    public static ArrayList<String> Permutation2(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return list;
        }
        solve2(str.toCharArray(), 0, list);
        Collections.sort(list);
        return list;
    }

    private static void solve2(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            String str = String.valueOf(chars);
            if (!list.contains(str)) {
                list.add(str);
            }
        } else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                solve2(chars, i + 1, list);
                swap(chars, i, j);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


    public static void main(String[] args) {
        String str = "aa";
        System.out.println(Permutation2(str));
    }
}

