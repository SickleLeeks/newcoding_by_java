package com.company.day1028;

import java.util.*;

/**
 * 上升下降字符串
 */
public class UpAndDownString_Solution {
    public static String sortString(String s) {
        if ("".equals(s) || s.length() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (map.containsKey(chr)) {
                map.put(chr, map.get(chr) + 1);
            } else {
                map.put(chr, 1);
            }
        }
        boolean flag = true;
        while (!map.isEmpty()) {
            Set<Character> keys = map.keySet();
            Object[] keychr = keys.toArray();
            Arrays.sort(keychr);
            StringBuffer keysb = new StringBuffer();
            for (Object k : keychr) {
                keysb.append(k);
            }
            Collection<Integer> collection = map.values();
            Object[] obj = collection.toArray();
            Arrays.sort(obj);
            int min = (int) obj[0];
            int count = 0;
            while (count < min) {
                if (flag) {
                    flag = false;
                    sb.append(keysb.toString());
                } else {
                    keysb = keysb.reverse();
                    flag = true;
                    sb.append(keysb.toString());
                    keysb = keysb.reverse();
                }
                count++;
            }
            Iterator<Character> iter = keys.iterator();
            while (iter.hasNext()) {
                Character key = iter.next();
                if (map.get(key) - min == 0) {
                    iter.remove();
                } else {
                    map.put(key, map.get(key) - min);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String str = "aaaabbbbcccc";
        String str = "spo";
        System.out.println(sortString(str));
    }
}
