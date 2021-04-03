package com.jz.day1112;

import com.util.ListNode;

/**
 * 剑指offer： 链表中倒数第k个节点
 */
public class FindKthToTail {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        int k = 1;
        ListNode res = FindKthToTail(head, k);
        System.out.println(res.val);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public static ListNode FindKthToTail(ListNode pHead, int k) {
        int n = 0;
        ListNode point = pHead;
        while (point != null) {
            n++;
            point = point.next;
        }
        if (n < k) {
            return null;
        }
        if (n == k) {
            return pHead;
        }
        ListNode first = pHead;
        ListNode second = pHead;
        while (k >= 0) {
            first = first.next;
            k--;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second.next;
    }
}
