package com.nc.day1013;

import java.util.*;

public class TopKString_Solution {
    /**
     * return topK string
     *
     * @param strings string字符串一维数组 strings
     * @param k       int整型 the k
     * @return string字符串二维数组
     */
    public static String[][] topKstrings(String[] strings, int k) {
        // write code here
        if (strings == null || strings.length == 0) {
            return new String[][]{};
        }
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            if (count.containsKey(strings[i])) {
                count.put(strings[i], count.get(strings[i]) + 1);
            } else {
                count.put(strings[i], 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(count.entrySet());
        list.sort((o1, o2) -> {
            if (o2.getValue() > o1.getValue()) {
                return 1;
            } else if (o2.getValue().equals(o1.getValue())) {
                return o1.getKey().compareTo(o2.getKey());
            } else {
                return -1;
            }
        });
//        for (Map.Entry<String, Integer> mapping : list) {
//            System.out.println(mapping.getKey() + ":" + mapping.getValue());
//        }
        String[][] res = new String[k][2];
        for (int i = 0; i < k; i++) {
            res[i][0] = list.get(i).getKey();
            res[i][1] = String.valueOf(list.get(i).getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"1", "1", "2", "3"};
        int k = 2;
        String[][] res = topKstrings(strings, k);
        for (int i = 0; i < k; i++) {
            System.out.println(res[i][0] + "," + res[i][1]);
        }
    }
}
