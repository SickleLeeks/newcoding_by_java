package com.jz.day1108;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNotRepeatingChar_JZ {
    /**
     * 第一个只出现一次的字符
     *
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar(String str) {
        if (str == null || "".equals(str) || str.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, -1);
            } else {
                map.put(ch, i);
            }
        }
        for (int i : map.values()) {
            if (i != -1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "google";
        System.out.println(FirstNotRepeatingChar(str));
    }
}
