package com.company.day1003;

import com.company.util.TreeNode;

public class NodeNum {
    /**
     * 计算完全二叉树的节点个数
     *
     * @param head
     * @return
     */
    public static int nodeNum(TreeNode head) {
        if (head == null) {
            return 0;
        } else if (head.left != null && head.right == null) {
            return 1 + nodeNum(head.left);
        } else if (head.left == null && head.right != null) {
            return 1 + nodeNum(head.right);
        } else {
            return 1 + nodeNum(head.left) + nodeNum(head.right);
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode node01 = new TreeNode(2);
        TreeNode node02 = new TreeNode(3);
        head.left = node01;
        head.right = node02;

        System.out.println(nodeNum(head));
    }
}
