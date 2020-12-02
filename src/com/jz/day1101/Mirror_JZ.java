package com.jz.day1101;

import com.nc.util.TreeNode;

public class Mirror_JZ {
    /**
     * 二叉树的镜像
     *
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
