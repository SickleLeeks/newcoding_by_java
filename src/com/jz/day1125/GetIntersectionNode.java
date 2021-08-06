package com.jz.day1125;

import com.util.ListNode;

import java.util.Map;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class GetIntersectionNode {
    /**
     * 双指针法
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
