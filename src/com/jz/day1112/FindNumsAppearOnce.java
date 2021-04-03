package com.jz.day1112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

/**
 * 剑指offer: 数组中只出现一次的两个数字
 */
public class FindNumsAppearOnce {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(",");
        int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        int[] res = FindNumsAppearOnce(nums);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public static int[] FindNumsAppearOnce(int[] array) {
        // write code here
        if (array == null || array.length == 0) {
            return array;
        }
        int eor = 0;
        for (int i = 0; i < array.length; i++) {
            eor ^= array[i];
        }
        // 找出异或结果的二进制表示中最右位置的'1'
        int t = 1;
        while ((eor & t) == 0) {
            t <<= 1;
        }
        int ans1 = 0, ans2 = 0;
        // 根据标志位分别提取两个数字
        for (int i = 0; i < array.length; i++) {
            if ((t & array[i]) == 0) {
                ans1 ^= array[i];
            } else {
                ans2 ^= array[i];
            }
        }
        int[] res = new int[2];
        res[0] = Math.min(ans1, ans2);
        res[1] = Math.max(ans1, ans2);
        return res;
    }
}
