package com.jz.day1103;

import com.nc.util.ListNode;

public class Merge_JZ {
    /**
     * 合并两个排序的链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode dumpy = new ListNode(-1);
        dumpy.next = p1.val < p2.val ? p1 : p2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {

            }
        }
    }

    public static void main(String[] args) {
        var list1 = new ListNode(1);
        var node11 = new ListNode(3);
        var node12 = new ListNode(5);

        var list2 = new ListNode(2);
        var node21 = new ListNode(4);
        var node22 = new ListNode(6);

        list1.next = node11;
        node11.next = node12;

        list2.next = node21;
        node21.next = node22;

        ListNode root = Merge(list1, list2);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
