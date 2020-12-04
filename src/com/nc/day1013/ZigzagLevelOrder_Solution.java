package com.nc.day1013;

import com.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ZigzagLevelOrder_Solution {
    /**
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList <>>
     */
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        ArrayList<Integer> tmp = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        boolean flag = true;
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (stack2.isEmpty() && !stack1.isEmpty()) {
                while (!stack1.isEmpty()) {
                    TreeNode top = stack1.pop();
                    tmp.add(top.val);
                    if (top.left != null || top.right != null) {
                        if (flag) {
                            if (top.left != null) {
                                stack2.push(top.left);
                            }
                            if (top.right != null) {
                                stack2.push(top.right);
                            }
                        } else {
                            if (top.right != null) {
                                stack2.push(top.right);
                            }
                            if (top.left != null) {
                                stack2.push(top.left);
                            }
                        }
                    }
                }
                res.add(tmp);
                tmp = new ArrayList<>();
                flag = false;
            }
            if (stack1.isEmpty() && !stack2.isEmpty()) {
                while (!stack2.isEmpty()) {
                    TreeNode top = stack2.pop();
                    tmp.add(top.val);
                    if (top.left != null || top.right != null) {
                        if (flag) {
                            if (top.left != null) {
                                stack1.push(top.left);
                            }
                            if (top.right != null) {
                                stack1.push(top.right);
                            }
                        } else {
                            if (top.right != null) {
                                stack1.push(top.right);
                            }
                            if (top.left != null) {
                                stack1.push(top.left);
                            }
                        }
                    }
                }
                res.add(tmp);
                tmp = new ArrayList<>();
                flag = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        ArrayList<ArrayList<Integer>> res = zigzagLevelOrder(root);
        System.out.println(Arrays.toString(res.toArray()));
    }
}
