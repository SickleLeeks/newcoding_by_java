package com.nc.day1030;

import java.util.Arrays;
import java.util.HashMap;

public class MLS_Solution {
    /**
     * 数组中最长连续子序列
     * max increasing subsequence
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    // 统计连续序列长度：遇到重复元素跳过；遇到不连续元素重置；遇到连续元素加一并更新max
    public static int MLS(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int res = 1, count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == 1) {
                count += 1;
                res = Math.max(res, count);
            } else if (arr[i] == arr[i - 1]) {
                continue;
            } else {
                count = 1;
            }
        }
        return res;
    }

    /**
     * 1.HashMap保存每个连续序列中以左边界和右边界的值为key，序列长度为value的键值对
     * 2.每次遇到新的元素x，检查HashMap中是否存在x-1和x+1的序列以及序列长度left和right；计算x所在的序列长度，并更新x、x-left（序列的左边界）、x+right（序列的右边界）的value为这个长度
     * 3.循环的过程中持续更新max
     *
     * @param arr
     * @return
     */
    public static int MLS2(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int x : arr) {
            if (!map.containsKey(x)) {
                int left = map.getOrDefault(x - 1, 0);
                int right = map.getOrDefault(x + 1, 0);
                int sum = left + right + 1;
                map.put(x, sum);
                map.put(x - left, sum);
                map.put(x + right, sum);
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(MLS2(arr));
    }
}
