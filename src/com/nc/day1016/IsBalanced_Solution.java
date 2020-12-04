package com.nc.day1016;

import com.util.TreeNode;

/**
 * 是否为平衡二叉树
 */
public class IsBalanced_Solution {
    public static boolean isBalancedSolution(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(deepLength(root.left) - deepLength(root.right)) <= 1;
    }

    private static int deepLength(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return 1 + Math.max(deepLength(node.left), deepLength(node.right));
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        boolean res = isBalancedSolution(node0);
        System.out.println(res);
    }
}
