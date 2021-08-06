package com.jz.day1124;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Leetcode 671 二叉树中第二小的节点
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class FindSecondMinimumValue {
    public int res;
    public int rootVal;

    public int findSecondMinimumValue(TreeNode root) {
        res = -1;
        rootVal = root.val;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (res != -1 && node.val >= res) {
            return;
        }
        if (node.val > rootVal) {
            res = node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }

    Set<Integer> set = new HashSet<>();

    /**
     * 深度优先
     * @param root
     * @return
     */
    public int findSecondMinimumValue2(TreeNode root) {
        dfs2(root);
        if (set.size() < 2) return -1;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int val : set) {
            if (val <= first) { // 即val是最小值，first是次小值
                second = first;
                first = val;
            } else if (val <= second) { // val比first大，比second小，则val是次小值： first < val <= second
                second = val;
            }
        }
        return second;
    }

    private void dfs2(TreeNode node) {
        if (node == null) return;
        set.add(node.val);
        dfs2(node.left);
        dfs2(node.right);
    }
}
