package com.company.day1018;

import com.company.util.TreeNode;

public class IsSymmetric_Solution {
    /**
     * @param root TreeNode类
     * @return bool布尔型
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isChildSymmetric(root.left, root.right);
    }

    private static boolean isChildSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        } else {
            boolean res1 = isChildSymmetric(left.left, right.right);
            if (!res1) {
                return false;
            }
            return isChildSymmetric(left.right, right.left);
        }
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        System.out.println(isSymmetric(node0));
    }
}
