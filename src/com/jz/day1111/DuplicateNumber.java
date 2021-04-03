package com.jz.day1111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 剑指Offer： 数组中重复的数字
 */
public class DuplicateNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(",");
        int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        int res = duplicate(nums);
        System.out.println(res);
    }

    /**
     * @param numbers int整型一维数组
     * @return int整型
     */
    public static int duplicate(int[] numbers) {
        int[] countary = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            countary[numbers[i]]++;
            if (countary[numbers[i]] > 1) {
                return numbers[i];
            }
        }
        return -1;
    }
}
