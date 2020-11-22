package com.company.day1004;

import com.company.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrder_Solution {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;

        ArrayList<ArrayList<Integer>> res = levelOrder(node1);
        for (ArrayList<Integer> list : res) {
            System.out.println(list);
        }
    }

    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> nodequeue1 = new LinkedList<>();
        Queue<TreeNode> nodequeue2 = new LinkedList<>();
        nodequeue1.add(root);
        while (!nodequeue1.isEmpty() || !nodequeue2.isEmpty()) {
            ArrayList<Integer> tmp = new ArrayList<>();
            while (!nodequeue1.isEmpty()) {
                TreeNode node = nodequeue1.poll();
                if (node.left != null) {
                    nodequeue2.offer(node.left);
                }
                if (node.right != null) {
                    nodequeue2.offer(node.right);
                }
                tmp.add(node.val);
            }
            res.add(tmp);
            nodequeue1 = nodequeue2;
            nodequeue2 = new LinkedList<>();
        }
        return res;
    }
}
