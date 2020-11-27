package com.nc.day1001;

import com.nc.util.TreeNode;

/**
 * 二叉树根节点到叶子节点的所有路径表示的数字之和
 */
public class SumNumbers_Solution {
    /**
     * @param root TreeNode类
     * @return int整型
     */
    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            return sum;
        } else {
            int tmp = 0;
            if (node.left != null) {
                tmp += dfs(node.left, sum * 10 + node.left.val);
            }
            if (node.right != null) {
                tmp += dfs(node.right, sum * 10 + node.right.val);
            }
            return tmp;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        System.out.println(sumNumbers(root));
    }
}
