package com.nc.day1002;

import com.nc.util.ListNode;

public class DetectCycle_Solution {
    /**
     * 返回链表环的入口
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head; // fast point
        ListNode p2 = head; // slow point
        while (p1 != null && p1.next != null) {
            p2 = p2.next;
            p1 = p1.next.next;
            if (p1 == p2) {
                p2 = head;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(2);
        ListNode node03 = new ListNode(3);
        ListNode node04 = new ListNode(4);
        ListNode node05 = new ListNode(5);
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        node05.next = node02;
        ListNode res = detectCycle(node01);
        System.out.println(res.val);
    }
}
