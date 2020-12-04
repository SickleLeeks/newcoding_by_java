package com.nc.day1019;

import com.util.ListNode;

public class DeleteDuplicates_Solution {
    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode point = head;
        while (point != null) {
            if (point.next!=null && point.val == point.next.val){
                point.next = point.next.next;
            }else{
                point = point.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(1);

        node0.next = node1;

        ListNode node = deleteDuplicates(node0);
        System.out.println(node.val);
    }
}
