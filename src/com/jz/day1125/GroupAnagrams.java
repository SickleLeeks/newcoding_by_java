package com.jz.day1125;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 面试题 10.02. 变位词组
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        List<List<String>> res = groupAnagrams(strs);
        for (List<String> r : res) {
            System.out.println(r.toString());
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                List<String> temp = map.get(key);
                temp.add(str);
                map.put(key, temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            }
        }
        return new ArrayList<>(map.values());
    }
}
