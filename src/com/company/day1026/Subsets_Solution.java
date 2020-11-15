package com.company.day1026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 集合的所有子集
 */
public class Subsets_Solution {
    static ArrayList<ArrayList<Integer>> res;

    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        res = new ArrayList<>();
        if (S == null || S.length <= 0) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(S); // 必须要有
        for (int i = 0; i <= S.length; i++) {
            boolean[] used = new boolean[S.length];
            solve(S, list, i, used);
        }
        return res;
    }

    private static void solve(int[] s, ArrayList<Integer> list, int count, boolean[] used) {
        if (list.size() == count) {
            ArrayList<Integer> tmp = new ArrayList<>(list);
            Collections.sort(tmp);
            if (!res.contains(tmp)) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (used[i]) {
                continue;
            }
            list.add(s[i]);
            used[i] = true;
            solve(s, list, count, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] S = new int[]{1, 3, 2, 6};
        ArrayList<ArrayList<Integer>> res = subsets(S);
        for (ArrayList list : res) {
            System.out.println(list);
        }
    }
}
