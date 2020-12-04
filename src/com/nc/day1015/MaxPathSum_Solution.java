package com.nc.day1015;

import com.util.TreeNode;

public class MaxPathSum_Solution {
    /**
     * 通过率10%
     */
    private static int MAX = Integer.MIN_VALUE;

    /**
     * @param root TreeNode类
     * @return int整型
     */
    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        maxNodePath(root);
        return MAX;
    }

    public static int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        int leftMax = Math.max(left, left + root.val);
        int rightMax = Math.max(right, right + root.val);
        int midMax = Math.max(Math.max(leftMax, rightMax), left + right + root.val);
        return Math.max(midMax, root.val);
    }

    /**
     * 通过率：30%
     *
     * @param root
     * @return
     */
    private static int maxNodePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(maxNodePath(root.left), 0);
        int rightMax = Math.max(maxNodePath(root.right), 0);
        MAX = Math.max(MAX, root.val + leftMax + rightMax);
        return Math.max(leftMax + root.val, rightMax + root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        TreeNode node1 = new TreeNode(-1);
//        TreeNode node2 = new TreeNode(10);
//        TreeNode node3 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(7);
//        TreeNode node5 = new TreeNode(9);
//        TreeNode node6 = new TreeNode(11);

        root.left = node1;
//        root.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;
        int res = maxPathSum(root);
        System.out.println(res);
    }
}
