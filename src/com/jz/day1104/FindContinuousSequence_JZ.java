package com.jz.day1104;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class FindContinuousSequence_JZ {
    /**
     * 和为S的连续正数序列
     *
     * @param sum
     * @return
     */
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum == 0 || sum == 1) {
            return res;
        }
        for (int n = sum - 1; n > 1; n--) {
            int num1 = 2 * sum + n - n * n;
            if ((num1 > 0) && (num1) % (2 * n) == 0) {
                int num2 = num1 / (2 * n);
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    list.add(num2 + i);
                }
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int sum = 3;
        System.out.println(FindContinuousSequence(sum));
    }
}
