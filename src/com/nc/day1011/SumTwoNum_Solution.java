package com.nc.day1011;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 两数之和
 */
public class SumTwoNum_Solution {
    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public static int[] twoSum(int[] numbers, int target) {
        // write code here
        if (numbers == null || numbers.length == 0) {
            return null;
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= numbers.length; i++) {
            map.put(i, numbers[i - 1]);
        }
        for (int i = 0; i < numbers.length; i++) {
            int other = target - numbers[i];
            if (map.containsValue(other)) {
                int curr = i + 1;
                List<Integer> index = map.entrySet().stream().filter(kv -> kv.getValue().equals(other) && !kv.getKey().equals(curr)).map(Map.Entry::getKey).collect(Collectors.toList());
                if (index.size() == 2) {
                    res[0] = index.get(0);
                    res[1] = index.get(1);
                    break;
                } else if (index.size() == 1) {
                    res[0] = i + 1;
                    res[1] = index.get(0);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{3, 2, 4};
        int targ = 6;
        int[] res = twoSum(num, targ);
        System.out.println(Arrays.toString(res));
    }
}
