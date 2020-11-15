package com.company.day1001;

import com.company.util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 根据前序数组和中序数组重建二叉树
 */
public class ReConstructBinaryTree_Solution {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        TreeNode head =  preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
        LinkedList<TreeNode> list = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        list.offer(head);
        while (!list.isEmpty()){
            TreeNode node = list.poll();
            if (node.left!=null){
                list.offer(node.left);
            }
            if (node.right!=null){
                list.offer(node.right);
            }
            res.add(node.val);
        }
        System.out.println(res);
        return head;
    }

    private static TreeNode preIn(int[] pre, int pi, int pj, int[] in, int ni, int nj, HashMap<Integer, Integer> map) {
        if (pi > pj) {
            return null;
        }
        TreeNode head = new TreeNode(pre[pi]);
        int index = map.get(head.val);
        head.left = preIn(pre, pi + 1, pi + index - ni, in, ni, index - 1, map);
        head.right = preIn(pre, pi + index - ni + 1, pj, in, index + 1, nj, map);
        return head;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] in = new int[]{3, 2, 4, 1, 6, 5, 7};
        TreeNode head = reConstructBinaryTree(pre, in);
        System.out.println(head.val);
    }
}
