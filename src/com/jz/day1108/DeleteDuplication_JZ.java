package com.jz.day1108;

import com.util.ListNode;

public class DeleteDuplication_JZ {
    /**
     * 删除链表中重复的结点
     *
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode vHead = new ListNode(-1);
        vHead.next = pHead;
        ListNode prev = vHead;
        ListNode curr = pHead;
        while (curr != null) {
            if (curr.next!=null&&curr.val==curr.next.val){
                curr = curr.next;
                while (curr.next!=null&&curr.val==curr.next.val){
                    curr = curr.next;
                }
                curr = curr.next;
                prev.next = curr;
            }else {
                prev = curr;
                curr = curr.next;
            }
        }
        return vHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode node = deleteDuplication(node1);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
