package com.jz.day1110;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Print_JZ {
    /**
     * 按之字形顺序打印二叉树
     *
     * @param pRoot
     * @return
     */
    static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return lists;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(pRoot);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode temp = stack1.pop();
                if (temp.left != null) {
                    stack2.push(temp.left);
                }
                if (temp.right != null) {
                    stack2.push(temp.right);
                }
                list.add(temp.val);
            }
            if (list.size() > 0) {
                lists.add(list);
            }
            list = new ArrayList<>();
            while (!stack2.isEmpty()) {
                TreeNode temp = stack2.pop();
                if (temp.right != null) {
                    stack1.push(temp.right);
                }
                if (temp.left != null) {
                    stack1.push(temp.left);
                }
                list.add(temp.val);
            }
            if (list.size() > 0) {
                lists.add(list);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        ArrayList<ArrayList<Integer>> res = Print(node1);
        for (ArrayList<Integer> list : res) {
            System.out.println(list);
        }
    }
}
