package com.nc.day1014;

import com.util.ListNode;

public class OddEvenList_Solution {
    /**
     * 链表的奇偶排序：双指针法
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head, even = head.next, oddCurr = odd, evenCurr = even;
        while (evenCurr != null && evenCurr.next != null) {
            oddCurr.next = evenCurr.next;
            oddCurr = oddCurr.next;
            evenCurr.next = oddCurr.next;
            evenCurr = evenCurr.next;
        }
        oddCurr.next = even;
        return head;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = oddEvenList(node0);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
