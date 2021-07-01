package com.jz.day1120;

import java.util.*;

/**
 * 找出字符串的最长无重复字符子串
 */
public class LongestUniqueStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int res = solution(str);
            System.out.println(res);
        }
        sc.close();
    }

    private static int solution(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) return 1;
        Set<Character> windows = new HashSet<>();
        int L = 0, R = 0, maxValue = 0;
        while (R < str.length()) {
            char chr = str.charAt(R++);
            while (windows.contains(chr)) {
                //移动左边界，缩小窗口
                windows.remove(str.charAt(L++));
            }
            windows.add(chr);
            maxValue = Math.max(maxValue, windows.size());
        }
        return maxValue;
    }
}
