package com.jz.day1130;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 646. 最长数对链
 */
public class FindLongestChain {
    // 贪心思想
    public static int findLongestChain(int[][] pairs) {
        if (pairs.length == 1) {
            return 1;
        }
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int chainStart = pairs[0][1];
        int res = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainStart) {
                chainStart = pairs[i][1];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] pairs = {{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
        System.out.println(findLongestChain(pairs));
    }
}
