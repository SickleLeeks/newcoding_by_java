package com.nc.day1007;

import com.util.TreeNode;

import java.util.*;

public class RightView_Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     *
     * @param xianxu  int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public static int[] solve(int[] xianxu, int[] zhongxu) {
        if (xianxu == null || zhongxu == null) {
            return null;
        }
        TreeNode root = rebuild(xianxu, 0, xianxu.length - 1, zhongxu, 0, zhongxu.length - 1);
        ArrayList<Integer> list = rightSideView(root);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static ArrayList<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode point = root;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                point = queue.poll();
                if (point.left != null) {
                    queue.offer(point.left);
                }
                if (point.right != null) {
                    queue.offer(point.right);
                }
            }
            list.add(point.val);
        }
        return list;
    }

    private static TreeNode rebuild(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preStart]);
        int index = inStart;
        while (in[index] != pre[preStart]) {
            index++;
        }
        node.left = rebuild(pre, preStart + 1, preStart + (index - inStart), in, inStart, index - 1);
        node.right = rebuild(pre, preStart + (index - inStart) + 1, preEnd, in, index + 1, inEnd);
        return node;
    }

    public static void main(String[] args) {
        int[] xianxu = new int[]{1, 2, 4, 5, 3};
        int[] zhongxu = new int[]{4, 2, 5, 1, 3};

        System.out.println(Arrays.toString(solve(xianxu, zhongxu)));
    }
}
