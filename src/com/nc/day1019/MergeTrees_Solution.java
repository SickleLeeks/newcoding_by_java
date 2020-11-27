package com.nc.day1019;


import com.nc.util.TreeNode;

public class MergeTrees_Solution {
    /**
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {
            TreeNode head = new TreeNode(t1.val + t2.val);
            head.left = mergeTrees(t1.left, t2.left);
            head.right = mergeTrees(t1.right, t2.right);
            return head;
        } else if (t1 == null) {
            return t2;
        } else {
            return t1;
        }
    }

    public static void main(String[] args) {
        TreeNode node01 = new TreeNode(1);
        TreeNode node02 = new TreeNode(3);
        TreeNode node03 = new TreeNode(2);
        TreeNode node04 = new TreeNode(5);

        node01.left = node02;
        node01.right = node03;
        node02.left = node04;

        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(1);
        TreeNode node13 = new TreeNode(3);
        TreeNode node14 = new TreeNode(4);
        TreeNode node15 = new TreeNode(7);

        node11.left = node12;
        node11.right = node13;
        node12.right = node14;
        node13.right = node15;

        TreeNode res = mergeTrees(node01, node11);
        System.out.println(res.val);
    }
}
