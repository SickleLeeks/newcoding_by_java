package com.nc.day1015;

import com.nc.util.TreeNode;

public class KthNode_Solution {
    /**
     * 二叉搜索树的第k个节点
     * 二叉搜索树的中序遍历就是树节点值得递增排列
     *
     * @param pRoot
     * @param k
     * @return
     */
    static TreeNode kNode = null;
    static int count = 0;

    private static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        inOrder(pRoot, k);
        return kNode;
    }

    public static void inOrder(TreeNode root, int k) {
        if (count < k && root.left != null) {
            inOrder(root.left, k);
        }
        if (++count == k) {
            kNode = root;
        }
        if (count < k && root.right != null) {
            inOrder(root.right, k);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeNode res = KthNode(root, 3);
        System.out.println(res.val);
    }
}
