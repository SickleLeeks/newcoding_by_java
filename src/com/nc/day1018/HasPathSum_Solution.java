package com.nc.day1018;

import com.util.TreeNode;

public class HasPathSum_Solution {
    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return bool布尔型
     */
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.right, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;

        boolean flag = hasPathSum(node0, 22);
        System.out.println(flag);
    }
}
