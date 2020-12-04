package com.nc.day1019;


import com.util.TreeNode;

public class SortedArrayToBST_Solution {
    /**
     * @param num int整型一维数组
     * @return TreeNode类
     */
    public static TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        return arrayToBST(num, 0, num.length - 1);
    }

    private static TreeNode arrayToBST(int[] num, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(num[left]);
        }
        int mid = left + (right - left + 1) / 2;
        TreeNode leftNode = arrayToBST(num, left, mid - 1);
        TreeNode rightNode = arrayToBST(num, mid + 1, right);
        TreeNode node = new TreeNode(num[mid]);
        if (leftNode != null) {
            node.left = leftNode;
        }
        if (rightNode != null) {
            node.right = rightNode;
        }
        return node;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2};
        TreeNode res = sortedArrayToBST(arr);
        System.out.println(res.val);
    }
}
