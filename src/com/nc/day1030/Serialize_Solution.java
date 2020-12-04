package com.nc.day1030;

import com.util.TreeNode;

public class Serialize_Solution {
    /**
     * 序列化与反序列化二叉树
     * 使用!来分割值value,使用#来代替null值
     *
     * @param root
     * @return
     */
    static String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        return serializeSolve(root, new StringBuilder()).toString();
    }

    private static StringBuilder serializeSolve(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return sb;
        }
        sb.append(root.val).append("!");
        if (root.left != null) {
            serializeSolve(root.left, sb);
        } else {
            sb.append("#!");
        }
        if (root.right != null) {
            serializeSolve(root.right, sb);
        } else {
            sb.append("#!");
        }
        return sb;
    }

    /**
     * 反序列化的时候，由于采用的是先序遍历，此时如果遇到了#号，则左边结束了,要开启右边，如果再次遇到#,表示当前整个部分的左边结束了要开始右子树。。依次类推。
     *
     * @param str
     * @return
     */
    static int index = 0;

    static TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] split = str.split("!");
        return deserializeSolve(split);
    }

    private static TreeNode deserializeSolve(String[] strings) {
        if ("#".equals(strings[index])) {
            index++;
            return null;
        }
        // 当前值作为节点已经被用
        TreeNode root = new TreeNode(Integer.parseInt(strings[index]));
        index++;
        root.left = deserializeSolve(strings);
        root.right = deserializeSolve(strings);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        String str = Serialize(node1);
        System.out.println(str);

        System.out.println(Deserialize(str).val);
    }
}
