package com.jz.day1123;

import java.util.*;

/**
 * Leetcode 1418 点菜展示表
 */
public class DisplayTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<String>> orders = new ArrayList<>();
        while (sc.hasNextLine()) {
            String string = sc.nextLine();
            if (string.equals("") || string.length() == 0) {
                break;
            }
            String[] str = string.split(",");
            List<String> order = new ArrayList<>();
            Collections.addAll(order, str);
            orders.add(order);
        }
        sc.close();
        List<List<String>> res = displayTable(orders);
        for (List<String> ord : res) {
            System.out.println(ord.toString());
        }

    }

    public static List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> table = new TreeMap<>();
        List<String> dishList = new ArrayList<>();
        for (List<String> order : orders) {
            int tableId = Integer.parseInt(order.get(1));
            String dish = order.get(2);
            if (!dishList.contains(dish)) {
                dishList.add(dish);
            }
            if (table.containsKey(tableId)) { //如果已经添加改餐桌
                Map<String, Integer> dishMap = table.get(tableId);
                dishMap.put(dish, dishMap.getOrDefault(dish, 0) + 1);
            } else {
                Map<String, Integer> disMap = new HashMap<>();
                disMap.put(dish, 1);
                table.put(tableId, disMap);
            }
        }
        Collections.sort(dishList);
        List<List<String>> res = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(dishList);
        res.add(header);
        for (Map.Entry<Integer, Map<String, Integer>> order : table.entrySet()) {
            List<String> ord = new ArrayList<>();
            ord.add(String.valueOf(order.getKey()));
            Map<String, Integer> dishMap = order.getValue();
            for (String str : dishList) {
                if (dishMap.containsKey(str)) {
                    ord.add(String.valueOf(dishMap.get(str)));
                } else {
                    ord.add("0");
                }
            }
            res.add(ord);
        }
        return res;
    }
}
