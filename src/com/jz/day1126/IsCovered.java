package com.jz.day1126;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 1893. 检查是否区域内所有整数都被覆盖
 */
public class IsCovered {
    public static void main(String[] args) {
        int[][] rangers = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int left = 2;
        int right = 5;
        System.out.println(isCovered(rangers, left, right));
    }

    // 方法1： 暴力法
    public static boolean isCovered(int[][] ranges, int left, int right) {
        Set<Integer> set = new HashSet<>();
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                set.add(i);
            }
        }
        for (int i = left; i <= right; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }

    // 方法2：基于排序
    public static boolean isCovered2(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, Comparator.comparingInt(o -> o[0]));
        for (int[] range : ranges) {
            int l = range[0];
            int r = range[1];
            if (l <= left && left <= r) {
                left = r + 1;
            }
        }
        return left > right;
    }
}
