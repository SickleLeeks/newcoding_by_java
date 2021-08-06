package com.jz.day1127;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Leetcode 987.二叉树的垂序遍历
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);
        Collections.sort(nodes, (node1, node2) -> {
            if (node1[0] != node2[0]) {
                // 如果列号不相等，则按照从小到大排序，反映到树上，则是从左到右
                return node1[0] - node2[0];
            } else if (node1[1] != node2[1]) {
                // 如果行号不相等，则按照从小到大排序，反映到树上，则是从上到下
                return node1[1] - node2[1];
            } else {
                // 按照值从小到大排序
                return node1[2] - node2[2];
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        int size = 0; // 记录列表索引最大值
        int lastcol = Integer.MAX_VALUE; //记录列号的变化情况
        for (int[] node : nodes) {
            int col = node[0], value = node[2];
            //如果列号发生变化，则创建新的列表
            if (col != lastcol) {
                lastcol = col;
                res.add(new ArrayList<>());
                size++;
            }
            res.get(size - 1).add(value); // 将元素添加到最大索引位置的列表中
        }
        return res;
    }

    private void dfs(TreeNode node, int row, int col, List<int[]> nodes) {
        if (node == null) {
            return;
        }
        nodes.add(new int[]{col, row, node.val});
        dfs(node.left, row + 1, col - 1, nodes); // 向左，则行数+1，列数-1
        dfs(node.right, row + 1, col + 1, nodes); // 向右，则行数+1，列数+1
    }
}
