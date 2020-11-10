package com.company.day1020;

public class Trans_Solution {
    public static String trans(String s, int n) {
        if (s == null || n == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        String strb = new StringBuilder(s).reverse().toString();
        String[] strs = strb.split(" ", -1);
        for (int i = 0; i < strs.length; i++) {
            if (!"".equals(strs[i])) {
                char[] chrs = new StringBuilder(strs[i]).reverse().toString().toCharArray();
                for (int j = 0; j < chrs.length; j++) {
                    if (chrs[j] >= 'A' && chrs[j] <= 'Z') {
                        chrs[j] = Character.toLowerCase(chrs[j]);
                    } else if (chrs[j] >= 'a' && chrs[j] <= 'z') {
                        chrs[j] = Character.toUpperCase(chrs[j]);
                    }
                }
                res.append(chrs);
                if (i != strs.length - 1) {
                    res.append(" ");
                }
            } else {
                res.append(" ");
            }
        }
        if (res.toString().length() > n) {
            return res.toString().substring(0, n);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "he is ";
        int n = 6;
        System.out.println(trans(str, n));
    }
}
