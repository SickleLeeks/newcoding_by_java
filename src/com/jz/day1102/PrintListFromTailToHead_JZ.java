package com.jz.day1102;

import com.util.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromTailToHead_JZ {
    /**
     * 从尾到头打印链表
     *
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }
        ListNode node = listNode;
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop().val);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(67);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(24);
        ListNode node3 = new ListNode(58);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        System.out.println(printListFromTailToHead(head));
    }
}
