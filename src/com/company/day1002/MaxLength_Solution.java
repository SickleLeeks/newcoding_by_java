package com.company.day1002;

import java.util.HashSet;

// 找到字符串的最长无重复字符字串
public class MaxLength_Solution {
    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int maxLength(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int p1 = 0, p2 = 0;
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        while (p1 < arr.length) {
            if (!set.contains(arr[p1])) {
                set.add(arr[p1]);
                p1++;
            } else {
                // arr[p2]必然和arr[p1]相等
                set.remove(arr[p2]);
                p2++;
            }
            max = Math.max(max, set.size());
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 4, 3};
        System.out.println(maxLength(arr));
    }
}
