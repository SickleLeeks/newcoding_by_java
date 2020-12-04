package com.nc.day1009;

import com.util.TreeNode;

import java.util.Arrays;

/**
 * 分别按照二叉树先序、中序和后序打印所有的节点
 */
public class PrintNode_Solution {
    private static int preIndex = 0;
    private static int midIndex = 0;
    private static int postIndex = 0;

    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public static int[][] threeOrders(TreeNode root) {
        int n = nodeCount(root);
        int[][] res = new int[3][n];

        int[] preRes = new int[n];
        int[] preOrder = preOrderSolution(root, preRes);
        int[] midRes = new int[n];
        int[] midOrder = midOrderSolution(root, midRes);
        int[] postRes = new int[n];
        int[] postOrder = postOrderSolution(root, postRes);

        for (int i = 0; i < preOrder.length; i++) {
            res[0][i] = preOrder[i];
        }
        for (int i = 0; i < midOrder.length; i++) {
            res[1][i] = midOrder[i];
        }
        for (int i = 0; i < postOrder.length; i++) {
            res[2][i] = postOrder[i];
        }
        return res;
    }

    private static int nodeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + nodeCount(root.left) + nodeCount(root.right);
    }

    // 后序遍历
    private static int[] postOrderSolution(TreeNode root, int[] postRes) {
        if (root != null) {
            postRes = postOrderSolution(root.left, postRes);
            postRes = postOrderSolution(root.right, postRes);
            postRes[postIndex++] = root.val;
        }
        return postRes;
    }

    // 中序遍历
    private static int[] midOrderSolution(TreeNode root, int[] midRes) {
        if (root != null) {
            midRes = midOrderSolution(root.left, midRes);
            midRes[midIndex++] = root.val;
            midRes = midOrderSolution(root.right, midRes);
        }
        return midRes;
    }

    /**
     * 先序遍历
     */
    private static int[] preOrderSolution(TreeNode root, int[] preRes) {
        if (root != null) {
            preRes[preIndex++] = root.val;
            preRes = preOrderSolution(root.left, preRes);
            preRes = preOrderSolution(root.right, preRes);
        }
        return preRes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int[][] res = threeOrders(root);
        System.out.print("[");
        for (int i = 0; i < 3; i++) {
            System.out.print(Arrays.toString(res[i]));
            if (i != 2) {
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }
}
