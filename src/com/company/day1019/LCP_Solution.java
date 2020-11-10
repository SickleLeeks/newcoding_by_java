package com.company.day1019;

import java.util.Arrays;

public class LCP_Solution {
    /**
     * @param strs string字符串一维数组
     * @return string字符串
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (true) {
            if ("".equals(strs[0])) {
                return "";
            }
            if (i < strs[0].length()) {
                char tmp = strs[0].charAt(i);
                boolean flag = true;
                for (int j = 1; j < strs.length; j++) {
                    if ("".equals(strs[j])) {
                        return "";
                    } else {
                        if ((i < strs[j].length() && strs[j].charAt(i) != tmp) || i == strs[j].length()) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    sb.append(tmp);
                    i++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"c", "c"};
        System.out.println(longestCommonPrefix(strings));
    }
}
