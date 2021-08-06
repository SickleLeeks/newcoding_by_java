package com.jz.day1122;

import java.util.*;

/**
 * Leetcode 451. 根据字符出现频率排序
 */
public class FrequencySort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String res = frequencySort2(s);
            System.out.println(res);
        }
        sc.close();
    }

    public static String frequencySort(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> mapping : list) {
            sb.append(String.join("", Collections.nCopies(mapping.getValue(), String.valueOf(mapping.getKey()))));
        }
        return sb.toString();
    }

    public static String frequencySort2(String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int freq = map.getOrDefault(s.charAt(i), 0) + 1;
            map.put(s.charAt(i), freq);
            maxFreq = Math.max(maxFreq, freq);
        }
        StringBuffer[] buckets = new StringBuffer[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new StringBuffer();
        }
        //按照出现的次数创建桶
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            buckets[entry.getValue()].append(entry.getKey());
        }
        StringBuffer sb = new StringBuffer();
        for (int i = maxFreq; i > 0; i--) {
            StringBuffer bucket = buckets[i];//得到每个桶
            //对于桶里的每个字符元素重复i次
            for (int j = 0; j < bucket.length(); j++) {
                sb.append(String.join("", Collections.nCopies(i, String.valueOf(bucket.charAt(j)))));
            }
        }
        return sb.toString();
    }
}
