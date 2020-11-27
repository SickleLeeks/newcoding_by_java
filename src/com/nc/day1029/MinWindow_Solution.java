package com.nc.day1029;

import java.util.HashMap;

public class MinWindow_Solution {
    /**
     * 最小覆盖子串
     * <p>
     * 1)begin开始指向0，end一直后移，直到begin-end区间内包含T中所有字符， 记录窗口长度d
     * 2)然后begin开始后移移除元素，直到移除的字符是T中的字符则停止，此时T中有一个字符没被b包含在窗口。
     * 3）继续后移end,直到T中所有字符都被包含在窗口，重新记录最小的窗口d
     * 4）如此循环直到end到S中的最后一个字符。
     * 时间复杂度为O(N)
     *
     * @param S string字符串
     * @param T string字符串
     * @return string字符串
     */
    public static String minWindow(String S, String T) {
        String res = "";
        if (S == null || T == null || S.length() < T.length()) {
            return res;
        }
        // map的key为T中出现的字符，value为出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            if (map.containsKey(T.charAt(i))) {
                map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
            } else {
                map.put(T.charAt(i), 1);
            }
        }
        // minleft为最小窗口左下标，minlen为最小长度，count用来计数
        int minLen = Integer.MAX_VALUE, count = 0;
        int left = 0;
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), map.get(S.charAt(i)) - 1);
                if (map.get(S.charAt(i)) >= 0) {
                    count++;
                }
                // 如果left到i中包含T中所有字符
                while (count == T.length()) {
                    if (map.containsKey(S.charAt(left))) {
                        if (i - left + 1 < minLen) {
                            minLen = i - left + 1;
                            res = S.substring(left, i + 1);
                        }
                        map.put(S.charAt(left), map.get(S.charAt(left)) + 1);
                        if (map.get(S.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "XDOYEZODEYXNZ";
        String T = "XYZ";
        System.out.println(minWindow(S, T));
    }
}
