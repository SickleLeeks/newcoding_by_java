package com.company.day1016;

import com.company.util.ListNode;

public class FindKthToTail_Solution {
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode point = head;
        int size = 0;
        while (head.next != null) {
            size++;
            head = head.next;
        }
        size += 1;
        int target = size - k;
        if (target >= 0) {
            for (int i = 0; i < size; i++) {
                if (i == target) {
                    return point;
                }
                point = point.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        int k = 6;
        ListNode res = FindKthToTail(node0, k);
        System.out.println(res.val);
    }
}
