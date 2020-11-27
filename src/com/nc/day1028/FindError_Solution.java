package com.nc.day1028;

import com.nc.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 找到搜索二叉树中两个错误的节点
 */
public class FindError_Solution {
    /**
     * @param root TreeNode类 the root
     * @return int整型一维数组
     */
    static int[] res = new int[2];
    static int curr = Integer.MIN_VALUE;

    public static int[] findError(TreeNode root) {
        inOrder(root);
        return res;
    }

    private static void inOrder(TreeNode root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        if (root.val < curr) {
            res[0] = root.val;
            res[1] = curr;
        } else {
            curr = root.val;
        }
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    public static int[] findError1(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, list);
        int[] orderd = list.stream().mapToInt(Integer::intValue).toArray();
        int[] index = new int[2];
        for (int i = 0; i < orderd.length - 1; i++) {
            if (orderd[i] > orderd[i + 1]) {
                index[i] = i;
            }
        }
        int[] res = new int[]{orderd[index[0]], orderd[index[1] + 1]};
        Arrays.sort(res);
        return res;
    }

    private static void solve(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            solve(node.left, list);
        }
        list.add(node.val);
        if (node.right != null) {
            solve(node.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.left = node1;
        root.right = node2;

        System.out.println(Arrays.toString(findError(root)));
    }
}
