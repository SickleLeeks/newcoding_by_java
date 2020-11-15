package com.company.day1001;

import com.company.util.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树根节点到叶子节点和为指定值的路径
 * 回溯法
 */
public class PathSum_Solution {
    /**
     * @param root TreeNode类
     * @param sum  int整型
     * @return int整型ArrayList<ArrayList <>>
     */
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, 0, sum, list);
        return res;
    }

    private static void solve(TreeNode node, int account, int sum, ArrayList<Integer> list) {
        list.add(node.val);
        if (node.left == null && node.right == null && sum == (account + node.val)) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (node.left != null) {
            solve(node.left, account + node.val, sum, list);
            list.remove(list.size() - 1);
        }
        if (node.right != null) {
            solve(node.right, account + node.val, sum, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node4.left = node6;
        node4.right = node7;

        int sum = 22;
        ArrayList<ArrayList<Integer>> res = pathSum(root, sum);
        for (ArrayList<Integer> list : res) {
            System.out.println(list);
        }
    }
}
