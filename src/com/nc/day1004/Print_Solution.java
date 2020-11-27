package com.nc.day1004;

import com.nc.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Print_Solution {
    private static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot==null){
            return res;
        }
        Queue<TreeNode> nodequeue1 = new LinkedList<>();
        Queue<TreeNode> nodequeue2 = new LinkedList<>();
        nodequeue1.add(pRoot);
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
        ArrayList<ArrayList<Integer>> res = Print(root);
        for (ArrayList<Integer> list : res) {
            System.out.println(list);
        }
    }
}
