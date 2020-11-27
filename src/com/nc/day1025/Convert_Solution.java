package com.nc.day1025;

import com.nc.util.TreeNode;

import java.util.ArrayList;

/**
 * 将二叉搜索树转换成一个排序的双向链表
 */
public class Convert_Solution {
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null)) {
            return pRootOfTree;
        }
        ArrayList<TreeNode> nodes = new ArrayList<>();
        midSort(pRootOfTree,nodes);
        TreeNode head = nodes.get(0);
        TreeNode curr = head;
        for (int i = 1; i < nodes.size(); i++) {
            TreeNode n = nodes.get(i);
            curr.right = n;
            n.left = curr;
            curr = n;
        }
        return head;
    }

    private static void midSort(TreeNode node,ArrayList<TreeNode> nodeList) {
        if (node.left!=null){
            midSort(node.left,nodeList);
        }
        nodeList.add(node);
        if (node.right!=null){
            midSort(node.right,nodeList);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(18);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(19);
        TreeNode node7 = new TreeNode(17);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node5.right = node7;

        System.out.println(Convert(root).val);
    }
}
