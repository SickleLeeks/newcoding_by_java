package com.jz.day1101;

import com.util.TreeNode;

public class KthNode_JZ {
    /**
     * 二叉搜索树的第k个节点
     *
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode kNode = null;
    int count = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        inOrder(pRoot, k);
        return kNode;
    }

    private void inOrder(TreeNode root, int k) {
        if (count < k && root.left != null) {
            inOrder(root.left, k);
        }
        if (++count == k) {
            kNode = root;
        }
        if (count < k && root.right != null) {
            inOrder(root.right, k);
        }
    }
}
