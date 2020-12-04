package com.jz.day1101;

import com.util.TreeNode;

public class TreeDepth_JZ {
    /**
     * 二叉树的深度
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }
}
