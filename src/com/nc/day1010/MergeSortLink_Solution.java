package com.nc.day1010;

import com.nc.util.ListNode;

/**
 * 合并有序链表
 */
public class MergeSortLink_Solution {
    /**
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = l1.val <= l2.val ? l1 : l2;
        if (node == l1) {
            l1 = l1.next;
            node.next = mergeTwoLists(l1, l2);
        }
        if (node == l2) {
            l2 = l2.next;
            node.next = mergeTwoLists(l1, l2);
        }
        return node;
    }

    public static void listToString(ListNode node) {
        System.out.print("{");
        while (node != null && node.next != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        if (node == null) {
            System.out.print("}");
        } else {
            System.out.print(node.val + "}");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node01 = new ListNode(4);
        ListNode node02 = new ListNode(5);

        head1.next = node01;
        node01.next = node02;

        ListNode head2 = new ListNode(2);
        ListNode node11 = new ListNode(3);
        ListNode node12 = new ListNode(6);

        head2.next = node11;
        node11.next = node12;

        ListNode newHead = mergeTwoLists(head1, head2);
        listToString(newHead);
    }
}
