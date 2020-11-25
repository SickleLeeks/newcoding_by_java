package com.company.day1008;

import com.company.util.ListNode;

import java.util.ArrayList;

/**
 * 合并k个已排序的链表
 */
public class MergeKLists_Solution {
    /**
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.size() - 1);
    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists, int left, int right) {
        if (left >= right) {
            return lists.get(left);
        }
        int mid = left + (right - left) / 2;
        ListNode p1 = mergeKLists(lists, left, mid);
        ListNode p2 = mergeKLists(lists, mid + 1, right);
        return merge(p1, p2);
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val < head2.val) {
            head1.next = merge(head1.next, head2);
            return head1;
        } else {
            head2.next = merge(head1, head2.next);
            return head2;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(2);

        ListNode node2 = new ListNode(1);
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(2);

        node1.next = node11;
        node11.next = node12;

        node2.next = node21;
        node21.next = node22;
        node22.next = node23;

        ArrayList<ListNode> list = new ArrayList<>();
        list.add(node1);
        list.add(node2);

        ListNode root = mergeKLists(list);
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }
}
