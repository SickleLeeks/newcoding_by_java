package com.nc.day1018;

import java.util.HashMap;
import java.util.Map;

public class MaxlenEqualK_Solution {
    /**
     * max length of the subarray sum = k
     *
     * @param arr int整型一维数组 the array
     * @param k   int整型 target
     * @return int整型
     */
    public static int maxlenEqualK(int[] arr, int k) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int res = Integer.MIN_VALUE;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            if (!map.containsKey(count)) {
                map.put(count, i);
            }
            if (map.containsKey(count - k) && i - map.get(count - k) > res) {
                res = i - map.get(count - k);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 1, 1, 1};
        int k = 0;
        System.out.println(maxlenEqualK(arr, k));
    }
}
