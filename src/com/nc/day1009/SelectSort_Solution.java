package com.nc.day1009;

import com.nc.util.ListNode;

public class SelectSort_Solution {
    /**
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public static ListNode sortInList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int n = nodeCount(head);
        ListNode root = head;
        while (root.next != null) {
            ListNode tmp = root;
            int min = root.val;
            ListNode minNode = tmp;
            while (tmp.next != null) {
                tmp = tmp.next;
                if (tmp.val < min) {
                    min = tmp.val;
                    minNode = tmp;
                }
            }
            if (minNode != root) {
                int temp = root.val;
                root.val = min;
                minNode.val = temp;
            }
            root = root.next;
        }
        return head;
    }

    private static int nodeCount(ListNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + nodeCount(head.next);
    }

    private static void ListNodeToString(ListNode head) {
        while (head.next != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.print(head.val);
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNodeToString(head);
        ListNode newHead = sortInList(head);
        ListNodeToString(newHead);
    }
}
