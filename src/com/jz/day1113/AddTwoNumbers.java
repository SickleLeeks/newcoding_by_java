package com.jz.day1113;

import com.util.ListNode;

/**
 * Leetcode: 2两数相加
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        ListNode l14 = new ListNode(9);
        ListNode l15 = new ListNode(9);
        ListNode l16 = new ListNode(9);
        ListNode l17 = new ListNode(9);

        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        ListNode l24 = new ListNode(9);

        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;
        l15.next = l16;
        l16.next = l17;

        l21.next = l22;
        l22.next = l23;
        l23.next = l24;

        ListNode res = addTwoNumbers(l11, l21);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode point = new ListNode(0);
        ListNode head = point;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + tmp;
            ListNode temp = new ListNode(sum % 10);
            tmp = sum / 10;
            point.next = temp;
            point = point.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null || l2 == null) {
            point.next = l1 == null ? l2 : l1;
            while (point.next != null) {
                point = point.next;
                int sum = point.val + tmp;
                point.val = sum % 10;
                tmp = sum / 10;
            }
            if (tmp > 0) {
                ListNode last = new ListNode(tmp);
                point.next = last;
            }
        }
        return head.next;
    }
}
