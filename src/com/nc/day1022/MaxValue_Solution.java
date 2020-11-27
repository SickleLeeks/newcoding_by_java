package com.nc.day1022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxValue_Solution {
    /**
     * 最大数
     *
     * @param nums int整型一维数组
     * @return string字符串
     */
    public static String solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        // 冒泡
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                String a = String.valueOf(nums[j]);
                String b = String.valueOf(nums[j + 1]);
                String combine1 = a + b, combine2 = b + a;
                if (!compare(combine1, combine2)) {
                    swap(nums, j, j + 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static boolean compare(String combine1, String combine2) {
        int i = Integer.parseInt(combine1);
        int j = Integer.parseInt(combine2);
        return i >= j;
    }

    public static String solve1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        List<String> list = new ArrayList<>();
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                flag = false;
            }
            list.add(nums[i]+"");
        }
        if (flag){
            return "0";
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0};
        String res = solve1(nums);
        System.out.println(res);
    }
}
