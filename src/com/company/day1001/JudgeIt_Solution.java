package com.company.day1001;

import com.company.util.TreeNode;

import java.util.*;

/**
 * 判断一颗二叉树是否为搜索二叉树和完全二叉树
 */
public class JudgeIt_Solution {
    /**
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public static boolean[] judgeIt(TreeNode root) {
        // 判断是否为一棵搜索二叉树
        boolean isBST = judgeBST(root);
        // 判断是否为一颗完全二叉树
        boolean isCBT = judgeCBT(root);
        return new boolean[]{isBST, isCBT};
    }

    /**
     * 使用改写的Morris中序遍历，判断节点值是否都是递增的
     * Morris遍历的实质就是避免用栈结构，而是让下层到上层有指针
     * 具体是通过让底层节点指向null的空闲指针指回上层的某个节点，从而完成下层到上层的移动。
     *
     * @param root
     * @return
     */
    private static boolean judgeBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean res = true;
        ArrayList<Integer> list = new ArrayList<>();
        preSort(root, list);
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < min) {
                res = false;
                return res;
            }
            min = list.get(i);
        }
//        TreeNode pre = null;
//        TreeNode cur1 = root;
//        TreeNode cur2 = null;
//        while (cur1 != null) {
//            cur2 = cur1.left;
//            if (cur2 != null) {
//                while (cur2.right != null && cur2.right != cur1) {
//                    cur2 = cur2.right;
//                }
//                if (cur2.right == null) {
//                    cur2.right = cur1;
//                    cur1 = cur1.left;
//                    continue;
//                } else {
//                    cur2.right = null;
//                }
//            }
//            if (pre != null && pre.val > cur1.val) {
//                res = false;
//            }
//            pre = cur1;
//            cur1 = cur1.right;
//        }
        return res;
    }

    private static void preSort(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        preSort(node.left, list);
        list.add(node.val);
        preSort(node.right, list);
    }

    /**
     * 判断是否为一颗完全二叉树
     * 1. 按层次遍历二叉树,从每层的左边向右依次遍历所有的节点
     * 2. 如果当前节点右有孩子，但是没有左孩子，直接返回false
     * 3. 如果当前节点并不是左右孩子全有，那之后的节点必须都为叶节点，否则返回false
     * 4. 遍历过程中如果不反悔false，结束后返回true
     *
     * @param root
     * @return
     */
    private static boolean judgeCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
//        boolean leaf = false;
//        TreeNode left = null;
//        TreeNode right = null;
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            root = queue.peek();
//            // 如果该节点两个孩子都有，则直接弹出
//            if (root.left != null && root.right != null) {
//                queue.poll();
//            }
//            // 如果该节点左孩子为空，右孩子不为空，则直接返回false
//            if (root.left == null && root.right != null) {
//                return false;
//            }
//            // 如果该节点左孩子不为空，右孩子为空或者该节点为叶子节点，则该节点之后的所有节点都是叶子节点
//            if ((root.left != null && root.right == null) || (root.left == null && root.right == null)) {
//                if (root.left != null && root.right == null) {
//                    queue.offer(root.left);
//                }
//                queue.poll();// 该节点之后的所有节点都是叶子节点
//                while (!queue.isEmpty()) {
//                    root = queue.peek();
//                    if (root.left == null && root.right == null) {
//                        queue.poll();
//                    } else {
//                        return false;
//                    }
//                }
//                return true;
//            }
//            return true;
//        }
//        return true;
        queue.offer(root);
        // 1. 层次遍历直到遇到第一个空节点
        // 2. 完全二叉树在遇到空节点之后剩余的应当全是空节点
        while (queue.peek() != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        System.out.println(Arrays.toString(judgeIt(root)));
    }
}
