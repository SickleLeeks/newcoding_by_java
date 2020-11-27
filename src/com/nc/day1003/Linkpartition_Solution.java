package com.nc.day1003;

import com.nc.util.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 划分链表
 */
public class Linkpartition_Solution {
    /**
     * @param head ListNode类
     * @param x    int整型
     * @return ListNode类
     */
    public static ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode point = head;
        Queue<ListNode> queue1 = new LinkedList<>();
        Queue<ListNode> queue2 = new LinkedList<>();
        Queue<ListNode> queue3 = new LinkedList<>();
        while (point != null) {
            if (point.val < x) {
                ListNode tmp = point;
                point = point.next;
                tmp.next = null;
                queue1.add(tmp);
                continue;
            }
            break;
        }
        while (point != null) {
            ListNode tmp = point;
            point = point.next;
            tmp.next = null;
            if (tmp.val >= x) {
                queue2.add(tmp);
            } else {
                queue3.add(tmp);
            }
        }
        ListNode newhead = queue1.isEmpty() ? (queue3.isEmpty() ? head : queue3.poll()) : queue1.poll();
        point = newhead;
        while (!queue1.isEmpty()) {
            point.next = queue1.poll();
            point = point.next;
        }
        while (!queue3.isEmpty()) {
            point.next = queue3.poll();
            point = point.next;
        }
        while (!queue2.isEmpty()) {
            point.next = queue2.poll();
            point = point.next;
        }
        return newhead;
    }

    /**
     * 新建两个节点preHead1和preHead2，分别指向两个链表的头结点，把节点值小于x的节点链接到链表1上，节点值大于等于x的节点链接到链表2上，最后把两个链表相连即可
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition2(ListNode head, int x) {
        ListNode preHead1 = new ListNode(0), cur1 = preHead1;
        ListNode preHead2 = new ListNode(0), cur2 = preHead2;
        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur1.next = preHead2.next;
        cur2.next = null;
        return preHead1.next;
    }

    public static void main(String[] args) {
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(4);
        ListNode node03 = new ListNode(5);
        ListNode node04 = new ListNode(2);
        ListNode node05 = new ListNode(3);
        ListNode node06 = new ListNode(2);

        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        node05.next = node06;

        int x = 3;
        ListNode res = partition2(node01, x);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
