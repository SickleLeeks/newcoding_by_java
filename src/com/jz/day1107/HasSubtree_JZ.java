package com.jz.day1107;

import com.util.TreeNode;

public class HasSubtree_JZ {
    /**
     * 树的子结构
     *
     * @param root1
     * @param root2
     * @return
     */
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null ^ root2 == null) {
            return false;
        } else {
            if (root1.val == root2.val) {
                return HasSubtree(root1.left, root2.left);
            } else {
                return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);

        TreeNode root2 = new TreeNode(8);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(2);

        root1.left = node1;
        node1.left = node2;
        node2.right = node3;
        node3.right = node4;

        root2.left = node5;
        node5.right = node6;

        System.out.println(HasSubtree(root1, root2));
    }
}
