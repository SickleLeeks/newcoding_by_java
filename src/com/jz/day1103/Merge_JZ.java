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
        ListNode curr = dumpy; // 将当前指针指向头节点
        dumpy.next = p1.val < p2.val ? p1 : p2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next; // 当前指针向后移动
        }
        // 注意：如果p1为空，则最后一个元素为p2，反之亦然
        curr.next = p1 != null ? p1 : p2;
        return dumpy.next;
    }

    public static void main(String[] args) {
        var list1 = new ListNode(1);
        var node11 = new ListNode(2);
        var node12 = new ListNode(2);
        var node13 = new ListNode(3);
        var node14 = new ListNode(4);
        var node15 = new ListNode(5);

        var list2 = new ListNode(1);
        var node21 = new ListNode(2);
        var node22 = new ListNode(2);
        var node23 = new ListNode(3);
        var node24 = new ListNode(4);
        var node25 = new ListNode(5);

        list1.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;

        list2.next = node21;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;

        ListNode root = Merge(list1, list2);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
