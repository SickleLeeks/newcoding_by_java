package com.jz.day1107;

import java.util.*;

public class VerifySquenceOfBST_JZ {
    /**
     * 二叉搜索树的后序遍历序列
     *
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : sequence) {
            list.add(i);
        }
        return solve(list);
    }

    private static boolean solve(List<Integer> sequence) {
        if (sequence.size() == 0 || sequence.size() == 1) {
            return true;
        }
        int n = sequence.size() - 1;
        int root = sequence.get(n);
        List<Integer> smaller = new ArrayList<>();
        int s = 0;
        while (s <= n - 1) {
            if (sequence.get(s) < root) {
                smaller.add(sequence.get(s));
                s++;
                continue;
            }
            break;
        }
        if (s > n - 1) {
            return true;
        }
        List<Integer> larger = new ArrayList<>();
        while (s <= n - 1) {
            if (sequence.get(s) > root) {
                larger.add(sequence.get(s));
                s++;
                continue;
            }
            return false;
        }
        return solve(smaller) && solve(larger);
    }

    public static void main(String[] args) {
        int[] sequence = new int[]{5, 4, 3, 2, 1};
        System.out.println(VerifySquenceOfBST(sequence));
    }
}
