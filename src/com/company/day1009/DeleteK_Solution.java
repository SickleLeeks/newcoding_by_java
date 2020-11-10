package com.company.day1009;

import com.company.util.ListNode;

import java.util.List;

public class DeleteK_Solution {
    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int M = listLength(head);
        int K = M - n;
        if (K < 0) {
            return null;
        }
        if (K == 0) {
            return head.next;
        }
        ListNode pFront = head;
        for (int i = 0; i < K - 1; i++) {
            pFront = pFront.next;
        }
        pFront.next = pFront.next.next;
        return head;
    }

    private static int listLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + listLength(head.next);
    }

    public static void main(String[] args) {
        int K = 2;
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode newHead = removeNthFromEnd(head, K);
        System.out.print("{");
        while (newHead.next != null) {
            System.out.print(newHead.val + ",");
            newHead = newHead.next;
        }
        System.out.print(newHead.val + "}");
        System.out.println();
    }
}
