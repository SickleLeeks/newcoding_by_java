package com.nc.day1006;

import com.nc.util.ListNode;

public class DeleteDuplicates_Solution {
    /**
     * 删除有序链表中重复出现的元素
     * 1. 设置伪节点，方便处理
     * 2. 双指针prev和curr
     * 3. 当遇到当前节点值和下一个节点值相等的节点时，进行while循环找到下一个不相等的节点，挂到prev节点上
     * 4. 当遇到当前节点和下一个节点值不相等的节点时，prev和curr都移动到下一个节点接着遍历即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 设置伪节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                ListNode temp = curr.next;
                while (temp != null && temp.val == curr.val) {
                    temp = temp.next;
                }
                prev.next = temp;
                curr = temp;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode res = deleteDuplicates(node1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
