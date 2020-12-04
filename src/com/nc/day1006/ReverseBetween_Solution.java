package com.nc.day1006;

import com.util.ListNode;

/**
 * 链表内指定区间反转
 */
public class ReverseBetween_Solution {
    /**
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // 计算length, 并把mPre和nNext找出来
        ListNode temp = head;
        ListNode mPre = null;
        ListNode nNxt = null;
        int len = 0;
        while (temp != null) {
            len += 1;
            if (len == m - 1) {
                mPre = temp;
            }
            if (len == n + 1) {
                nNxt = temp;
            }
            temp = temp.next;
        }
        // 判断1<=m<=n<=len
        if (m > n || m < 1 || n > len) {
            return head;
        }
        // 先反转m->n的节点，再连接mPre和nNxt
        // 定义三个辅助指针
        ListNode n1 = (mPre==null)?head:mPre.next;
        ListNode n2 = n1.next;
        ListNode n3 = null;
        n1.next = nNxt;//m的next指向n的next
        while (n2!=nNxt){
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }// 循环结束，n1指向nNxt
        // 判断是否换头，根据mPre是否为head
        if (mPre==null){
            return n1;
        }else {
            mPre.next = n1;
            return head;
        }
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

        int m = 2;
        int n = 4;

        ListNode res = reverseBetween(node1, m, n);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
