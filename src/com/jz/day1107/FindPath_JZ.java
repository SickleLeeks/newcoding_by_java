package com.jz.day1107;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindPath_JZ {
    /**
     * 二叉树中和为某一值的路径
     *
     * @param root
     * @param target
     * @return
     */
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    static Stack<Integer> path = new Stack<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        path.push(root.val);
        target -= root.val;
        // 当前路径遍历结束时，若节点值之和等于target，则将该路径加入正确路径队列
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        // 当前节点判断结束，回溯
        path.pop();
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        ArrayList<ArrayList<Integer>> lists = FindPath(node1, 22);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
