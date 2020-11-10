package com.company.day1015;

import com.company.util.TreeNode;

import java.util.Stack;

public class KthNode_Solution {
    static Stack<TreeNode> stack1 = new Stack<TreeNode>();

    private static TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot);
        int len = stack1.size();
        int i; //栈，队列，列表的长度均用size;
        if (len == 0 || k == 0) {
            return null;
        }
        if (len < k) {
            return null;
        }
        for (i = 1; i <= len - k; i++) {
            stack1.pop();
        }
        TreeNode node = stack1.pop();
        return node;
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        stack1.push(root);
        inOrder(root.right);
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
