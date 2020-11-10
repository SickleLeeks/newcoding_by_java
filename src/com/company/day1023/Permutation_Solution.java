package com.company.day1023;

import java.util.*;

/**
 * 字符串的全排列
 */
public class Permutation_Solution {

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        recur(str, "", res);
        return res;
    }

    private static void recur(String str, String curr, ArrayList<String> res) {
        if (str.length() == 0) {
            if (!res.contains(curr)) {
                res.add(curr);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            recur(str.substring(0, i) + str.substring(i + 1), curr + str.charAt(i), res);
        }
    }


    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> res = Permutation(str);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
