package com.nc.day1009;


import com.util.ListNode;

import java.util.Stack;

class ReverseLink_Solution {
    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> nodeStack = new Stack<>();
        while (head.next != null) {
            nodeStack.push(head);
            head = head.next;
        }
        ListNode pnew = head;
        while (!nodeStack.isEmpty()) {
            ListNode pTemp = nodeStack.pop();
            pTemp.next = null;
            head.next = pTemp;
            head = head.next;
        }
        return pnew;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNodeToString(node0);
        ListNode newHead = ReverseList(node0);
        ListNodeToString(newHead);
    }

    private static void ListNodeToString(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.print(head.val);
        System.out.println();
    }
}
