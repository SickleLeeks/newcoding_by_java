package com.jz.day1106;

import com.util.ListNode;

public class EntryNodeOfLoop_JZ {
    /**
     * 链表中环的入口节点
     *
     * @param pHead
     * @return
     */

    // 双指针法
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                break;
            }
        }
        p2 = pHead;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node2;

        ListNode entrance = EntryNodeOfLoop(head);
        System.out.println(entrance.val);
    }
}
