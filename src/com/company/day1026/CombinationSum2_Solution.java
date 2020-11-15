package com.company.day1026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 加起来和为目标值的组合
 * 回溯法
 */
public class CombinationSum2_Solution {
    static ArrayList<ArrayList<Integer>> res;

    public static Object combinationSum2(int[] num, int target) {
        res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        boolean[] used = new boolean[num.length];
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(num);
        solve(num, list, used, target);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> tmp : res) {
            Collections.sort(tmp);
            if (!result.contains(tmp)) {
                result.add(tmp);
            }
        }
        return result;
    }

    private static void solve(int[] num, ArrayList<Integer> list, boolean[] used, int target) {
        if (target == 0) {
            if (!res.contains(list)) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]) {
                continue;
            }
            if (num[i] > target) {
                continue;
            } else {
                list.add(num[i]);
                used[i] = true;
                solve(num, list, used, target - num[i]);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{3, 1, 3, 5, 1, 1};
        int target = 8;
        ArrayList<ArrayList<Integer>> res = (ArrayList<ArrayList<Integer>>) combinationSum3(num, target);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).stream().mapToInt(Integer::intValue).toArray()));
        }
    }

    public static Object combinationSum3(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        if (num == null || num.length == 0 || target < 0) {
            return res;
        }
        Arrays.sort(num);
        dfs(num, target, res, arr, 0);
        return res;
    }

    private static void dfs(int[] num, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> arr, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(arr));
            return;
        }
        if (start >= num.length) {
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i - 1]) {
                continue;
            }
            if (num[i] <= target) {
                arr.add(num[i]);
                dfs(num, target - num[i], res, arr, i + 1);
                arr.remove(arr.size() - 1);
            }
        }
        return;
    }
}
