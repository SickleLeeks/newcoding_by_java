package com.nc.day1011;

import com.nc.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个链表的第一个公共节点
 */
public class CommonNode_Solution {
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode res = null;
        while (pHead1.next != null) {
            nodeSet.add(pHead1);
            pHead1 = pHead1.next;
        }
        nodeSet.add(pHead1);
        while (pHead2 != null) {
            if (nodeSet.contains(pHead2)) {
                res = pHead2;
                break;
            }
            pHead2 = pHead2.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode head2 = new ListNode(7);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head2.next = node6;
        node6.next = node5;
        node5.next = node3;

        ListNode commonNode = FindFirstCommonNode(head1, head2);
        System.out.println(commonNode == null ? "" : commonNode.val);
    }
}
