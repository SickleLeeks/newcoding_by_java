package com.jz.day1110;

import com.util.TreeNode;

public class IsSymmetrical_JZ {
    /**
     * 对称二叉树
     *
     * @param pRoot
     * @return
     */
    static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) {
            return true;
        } else if (pRoot.left == null ^ pRoot.right == null) {
            return false;
        } else {
            if (pRoot.left.val == pRoot.right.val) {
                return solve(pRoot.left, pRoot.right);
            } else {
                return false;
            }
        }
    }

    private static boolean solve(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null ^ right == null) {
            return false;
        } else {
            if (left.val == right.val) {
                return solve(left.left, right.right) && solve(left.right, right.left);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        var node1 = new TreeNode(8);
        var node2 = new TreeNode(6);
        var node3 = new TreeNode(6);
        var node4 = new TreeNode(5);
        var node5 = new TreeNode(7);
        var node6 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        System.out.println(isSymmetrical(node1));
    }
}
