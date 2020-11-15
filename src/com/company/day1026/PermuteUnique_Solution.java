package com.company.day1026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 有重复数字项的所有排列
 * ！！！ 重要
 */
public class PermuteUnique_Solution {
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (num == null || num.length == 0) {
            return res;
        }
        if (num.length == 1) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(num[0]);
            res.add(list);
            return res;
        }
        ArrayList<Integer> numList = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            numList.add(num[i]);
        }
        for (int i = 1; i < num.length; i++) {
            int[] A = numList.subList(0, i).stream().mapToInt(Integer::intValue).toArray();
            int[] B = numList.subList(i, i + 1).stream().mapToInt(Integer::intValue).toArray();
            int[] C = numList.subList(i + 1, numList.size()).stream().mapToInt(Integer::intValue).toArray();

            ArrayList<Integer> listABC = combine(A, B, C);
            if (!res.contains(listABC)) {
                res.add(listABC);
            }
            ArrayList<Integer> listACB = combine(A, C, B);
            if (!res.contains(listACB)) {
                res.add(listACB);
            }
            ArrayList<Integer> listBCA = combine(B, C, A);
            if (!res.contains(listBCA)) {
                res.add(listBCA);
            }
            ArrayList<Integer> listBAC = combine(B, A, C);
            if (!res.contains(listBAC)) {
                res.add(listBAC);
            }
            ArrayList<Integer> listCBA = combine(C, B, A);
            if (!res.contains(listCBA)) {
                res.add(listCBA);
            }
        }
        return res;
    }

    private static ArrayList<Integer> combine(int[] A, int[] B, int[] C) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            res.add(A[i]);
        }
        for (int i = 0; i < B.length; i++) {
            res.add(B[i]);
        }
        for (int i = 0; i < C.length; i++) {
            res.add(C[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3};
        ArrayList<ArrayList<Integer>> res = permuteUnique2(num);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(Arrays.toString(res.get(i).stream().mapToInt(Integer::intValue).toArray()));
        }
    }

    static ArrayList<ArrayList<Integer>> res;

    public static ArrayList<ArrayList<Integer>> permuteUnique2(int[] num) {
        res = new ArrayList<>();
        if (num == null || num.length < 1) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (num.length == 1) {
            list.add(num[0]);
            res.add(list);
            return res;
        }
        Arrays.sort(num);
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
            if (i > 0 && num[i] == num[i - 1] && !used[i - 1]) {
                continue;
            }
            list.add(num[i]);
            used[i] = true;
            solve(list, num, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
