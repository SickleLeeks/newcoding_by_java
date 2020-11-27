package com.nc.day1030;

import com.nc.util.ListNode;

public class ReverseKGroup_Solution {
    /**
     * 链表中的节点每k个一组翻转
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dumpy = new ListNode(-1);
        dumpy.next = head;
        int len = 0;
        ListNode prev = dumpy, curr = head, next = null;
        ListNode index = head;
        while (index != null) {
            len++;
            index = index.next;
        }
        // 分段翻转
        for (int i = 0; i < len / k; i++) {
            for (int j = 1; j < k; j++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            // prev，curr需要更新至下一子序列的头部
            prev = curr;
            curr = curr.next;
        }
        return dumpy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode res = reverseKGroup(node1, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
