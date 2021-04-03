package com.jz.day1112;

import com.util.TreeNode;

/**
 * 剑指Offer: 二叉树的镜像
 */
public class Mirror {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(8);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        head.left = node1;
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;

        TreeNode res = Mirror(head);
        System.out.println(res.val);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public static TreeNode Mirror(TreeNode pRoot) {
        // write code here
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) {
            return pRoot;
        }
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
