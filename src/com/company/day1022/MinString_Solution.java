package com.company.day1022;

import java.util.Arrays;

public class MinString_Solution {
    /**
     * @param strs string字符串一维数组 the strings
     * @return string字符串
     */
    public static String minString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 比较字典序
        Arrays.sort(strs, (o1, o2) -> {
            String str1 = o1 + o2;
            String str2 = o2 + o1;
            return str1.compareTo(str2);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"abc", "de"};
        String res = minString(arr);
        System.out.println(res);
    }
}
