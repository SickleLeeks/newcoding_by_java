package com.nc.day1011;

import com.nc.util.ListNode;
import com.nc.util.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 在二叉树上找到两个节点的最近公共祖先
 */

/**
 * 最近公共祖先和o1，o2有三种关系：
 * 1. o1，o2 分别在祖先的左右两侧
 * 2. 祖先是o1，o2节点在祖先的左/右侧
 * 3. 祖先是o2，o1节点在祖先的左/右侧
 */
public class NearstNode_Solution {
    /**
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    // 使用DFS深度遍历，如果节点为o1，o2其中任意一个，直接返回，如果节点超过叶子节点也返回
    public static int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        return commonAncestor(root, o1, o2).val;
    }

    private static TreeNode commonAncestor(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2) {
            return root;
        }
        TreeNode left = commonAncestor(root.left, o1, o2);
        TreeNode right = commonAncestor(root.right, o1, o2);
        if (left == null) { // 都在右侧
            return right;
        }
        if (right == null) { // 都在左侧
            return left;
        }
        return root;
    }

    // 通过率只有15%
    public static int lowestCommonAncestor_me(TreeNode root, int o1, int o2) {
        // write code here
        ListNode listHead1 = findListNode(root, o1);
        ListNode listHead2 = findListNode(root, o2);
        ListNode commonAncestor = findCommonAncestor(listHead1, listHead2);
        return commonAncestor.val;
    }

    private static ListNode findCommonAncestor(ListNode listHead1, ListNode listHead2) {
        Set<Integer> set = new HashSet<>();
        ListNode res = null;
        while (listHead1 != null) {
            set.add(listHead1.val);
            listHead1 = listHead1.next;
        }
        while (listHead2 != null) {
            if (set.contains(listHead2.val)) {
                res = listHead2;
                break;
            }
            listHead2 = listHead2.next;
        }
        return res;
    }

    private static ListNode findListNode(TreeNode root, int target) {
        TreeNode point = root;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int count = 0;
        while (point != null && point.val != target) {
            if (point.left != null || point.right != null) {
                stack1.push(point);
                if (point.left != null) {
                    stack2.push(point.left);
                    count++;
                }
                if (point.right != null) {
                    stack2.push(point.right);
                    count++;
                }
            }
            if (!stack2.isEmpty()) {
                point = stack2.pop();
                count--;
            }
            if (count == 0) {
                stack1.pop();
            }
        }
        ListNode start = new ListNode(point.val);
        ListNode head = start;
        while (!stack1.isEmpty()) {
            ListNode node = new ListNode(stack1.pop().val);
            start.next = node;
            start = start.next;
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node7;
        node4.right = node8;
        node2.left = node5;
        node2.right = node6;

        int res = lowestCommonAncestor(root, 6, 0);
        System.out.println(res);
    }

}
