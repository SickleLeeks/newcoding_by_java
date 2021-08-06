package com.jz.day1125;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 863. 二叉树中所有距离为 K 的结点
 */
public class DistanceK {

    Map<TreeNode, TreeNode> parents = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 从根节点出发，寻找每个节点的父节点
        findParents(root);
        // 从target开始，进行深度优先搜索，寻找深度为k的节点
        findDistanceK(target, null, 0, k);
        return res;
    }

    private void findDistanceK(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            res.add(node.val);
            return;
        }
        if (node.left != from) {
            findDistanceK(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            findDistanceK(node.right, node, depth + 1, k);
        }
        if (parents.get(node) != from) {
            findDistanceK(parents.get(node), node, depth + 1, k);
        }
    }

    private void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right, node);
            findParents(node.right);
        }
    }
}
