package com.jz.day1116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 牛客网： 两数之和
 */
public class TwoSum {
    /**
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public static int[] twoSum(int[] numbers, int target) {
        // write code here
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int cur = 0, tmp; cur < numbers.length; cur++) {
            tmp = numbers[cur];
            if (numMap.containsKey(target - tmp)) {
                return new int[]{numMap.get(target - tmp) + 1, cur + 1};
            }
            numMap.put(tmp, cur);
        }
        throw new RuntimeException("results not exits");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(",");
        int target = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }
}
