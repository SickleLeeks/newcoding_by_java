package com.nc.day1015;

import com.nc.util.ListNode;

import java.util.Stack;

public class IsPail_Solution {
    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public static boolean isPail(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode point = head;
        while (point.next != null) {
            stack.push(point);
            point = point.next;
        }
        stack.push(point);
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            if (top.val == head.val) {
                if (head.next != null) {
                    head = head.next;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        boolean res = isPail(node0);
        System.out.println(res);
    }
}
