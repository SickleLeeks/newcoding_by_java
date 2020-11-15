package com.company.day1026;

import java.util.ArrayList;

public class Permute_Solution {
    static ArrayList<ArrayList<Integer>> res;

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (num.length == 1) {
            list.add(num[0]);
            res.add(list);
            return res;
        }
        boolean[] used = new boolean[num.length];
        solve(list, num, used);
        return res;
    }

    private static void solve(ArrayList<Integer> list, int[] num, boolean[] used) {
        if (list.size() == num.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]) {
                continue;
            }
            list.add(num[i]);
            used[i] = true;
            solve(list, num, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3};
        ArrayList<ArrayList<Integer>> res = permute(num);
        for (ArrayList list : res) {
            System.out.println(list);
        }
    }
}
