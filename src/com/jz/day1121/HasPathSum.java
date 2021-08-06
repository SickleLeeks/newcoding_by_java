package com.jz.day1121;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Leetcode: 112.路径总和
 */

//Definition for a binary tree node.
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

public class HasPathSum {
    //广度优先搜索
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode now = nodeQueue.poll();
            int temp = sumQueue.poll();
            if (now.left == null && now.right == null) {
                if (temp == targetSum) {
                    return true;
                }
            }
            if (now.left != null) {
                nodeQueue.offer(now.left);
                sumQueue.offer(temp + now.left.val);
            }
            if (now.right != null) {
                nodeQueue.offer(now.right);
                sumQueue.offer(temp + now.right.val);
            }
        }
        return false;
    }

    //递归
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum2(root.left, targetSum - root.val) ||
                hasPathSum2(root.right, targetSum - root.val);
    }
}
