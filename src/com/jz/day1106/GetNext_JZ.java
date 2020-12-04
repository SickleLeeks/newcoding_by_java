package com.jz.day1106;

import com.util.TreeLinkNode;

import java.util.ArrayList;

public class GetNext_JZ {
    /**
     * 二叉树的下一个结点
     *
     * @param pNode
     * @return
     */
    static ArrayList<TreeLinkNode> list = new ArrayList<>();

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode parrent = pNode;
        while (parrent.next != null) {
            parrent = parrent.next;
        }
        InOrder(parrent);
        for (int i = 0; i < list.size(); i++) {
            if (pNode == list.get(i)) {
                return i == list.size() - 1 ? null : list.get(i + 1);
            }
        }
        return null;
    }

    private static void InOrder(TreeLinkNode parrent) {
        if (parrent != null) {
            InOrder(parrent.left);
            list.add(parrent);
            InOrder(parrent.right);
        }
    }

    public static TreeLinkNode GetNext2(TreeLinkNode pNode) {
        // 情况1
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            return pRight;
        }
        // 情况2
        if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }
        // 情况3
        if (pNode.next != null) {
            TreeLinkNode pNext = pNode.next;
            while (pNext.next != null && pNext.next.right == pNext) {
                pNext = pNext.next;
            }
            return pNext.next;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.next = node1;
        node3.next = node1;

        TreeLinkNode res = GetNext(node1);
        System.out.println(res.val);
    }
}
