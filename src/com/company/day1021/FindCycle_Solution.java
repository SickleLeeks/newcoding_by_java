package com.company.day1021;

import com.company.util.ListNode;

import javax.security.sasl.Sasl;

/**
 * 判断给定的链表中是否有环
 */
public class FindCycle_Solution {
    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode pFast = head;
        ListNode pSlow = head;
        while (pFast.next != null && pFast.next.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
            if (pFast == pSlow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        ListNode head = node0;
        head.next = node1;
        node1.next = node2;
        node2.next = node0;

        boolean res = hasCycle(head);
        System.out.println(res);
    }
}
