package com.nc.day1018;

import com.nc.util.TreeNode;

public class IsContains_Solution {
    /**
     * @param root1 TreeNode类
     * @param root2 TreeNode类
     * @return bool布尔型
     */
    public static boolean isContains(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 == null ^ root2 == null) {
            return false;
        } else if (root1.val == root2.val) {
            boolean left = isContains(root1.left, root2.left);
            boolean right = isContains(root1.right, root2.right);
            return left && right;
        } else {
            boolean left = isContains(root1.left,root2);
            boolean right = isContains(root1.right,root2);
            return left || right;
        }
    }

    public static void main(String[] args) {
        TreeNode node01 = new TreeNode(1);
        TreeNode node02 = new TreeNode(2);
        TreeNode node03 = new TreeNode(3);
        TreeNode node04 = new TreeNode(4);
        TreeNode node05 = new TreeNode(5);
        TreeNode node06 = new TreeNode(6);
        TreeNode node07 = new TreeNode(7);
        TreeNode node08 = new TreeNode(8);
        TreeNode node09 = new TreeNode(9);

        node01.left = node02;
        node01.right = node03;
        node02.left = node04;
        node02.right = node05;
        node03.left = node06;
        node03.right = node07;
        node04.right = node08;
        node05.left = node09;

        System.out.println(isContains(node01, node02));
    }
}
