package com.company.day1007;

import com.company.util.TreeNode;

public class MaxPathSum_Solution {
    /**
     * 二叉树的最大路径和
     * 深度优先遍历
     *
     * @param root TreeNode类
     * @return int整型
     */
    static int maxValue = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxValue;
    }

    public static int maxPathDown(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 因为节点的值可以为负数，所以最大值取0和子树中值的较大者
        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));
        // 如果将当前root作为根节点，那么最大值是root.value+左子树最大值+右子树最大值
        maxValue = Math.max(maxValue, left + right + root.val);
        // 只能返回左右子树中较大值+root.value
        return Math.max(left, right) + root.val;
    }
}
