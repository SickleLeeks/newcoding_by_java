package com.nc.day1006;

import com.util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReorderList_Solution {
    /**
     * 重排链表
     * 使用双端队列
     *
     * @param head
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        ListNode point = head;
        while (point != null) {
            queue.add(point.val);
            point = point.next;
        }
        boolean flag = true;
        point = head;
        while (point != null) {
            if (flag) {
                point.val = queue.pollFirst();
                flag = false;
            } else {
                point.val = queue.pollLast();
                flag = true;
            }
            point = point.next;
        }
    }

    /**
     * 重排链表：原地算法
     * 1. 将链表从中间断开，分成两个链表：这里用快慢指针方法找到中间节点，再断开
     * 2. 反转第二个链表
     * 3. 将第二个链表一次插入到第一个链表
     *
     * @param head
     */
    public static void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        // 快慢指针，找到中间节点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode start = head;
        ListNode end = mid.next;
        mid.next = null;// 断开链表
        // 反转end链表，处理第一个节点
        ListNode pre = end;
        ListNode cur = pre.next;
        while (cur != null) {
            if (pre == end) {
                pre.next = null;
            }
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        end = pre;
        // 插入
        while (start != null && end != null) {
            ListNode next1 = start.next;
            ListNode next2 = end.next;
            start.next = end;
            end.next = next1;
            start = next1;
            end = next2;
        }
        return;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(30);
        ListNode node4 = new ListNode(40);
        ListNode node5 = new ListNode(50);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        reorderList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
