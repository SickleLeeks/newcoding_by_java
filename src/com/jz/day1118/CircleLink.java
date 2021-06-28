package com.jz.day1118;

import com.util.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 环形链表的约瑟夫问题
 * 思路：1.找到最后一个节点，2.从最后一个节点开始遍历，满足条件后剔除节点并计数清零
 * 复杂度：时间复杂度为O(N*M):N为链表长度，M为指定编号
 */
public class CircleLink {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] item = in.readLine().split(" ");
        int n = Integer.parseInt(item[0]);
        int m = Integer.parseInt(item[1]);
        int[] id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i + 1;
        }
        ListNode head = createLoopNodeList(id);
        ListNode stillAlive = killAllPeople(head, m);
        System.out.println(stillAlive.val);
    }

    private static ListNode killAllPeople(ListNode head, int m) {
        if (head == null || head == head.next || m < 1) {
            return head;
        }
        ListNode last = head;
        //找出最后一个节点
        while (last.next != head) {
            last = last.next;
        }

        //从最后一个节点开始遍历链表，curr表示当前节点，last表示当前节点的前一个节点
        int count = 0;
        ListNode curr = head;
        while (curr != last) {
            if (++count == m) {
                last.next = curr.next;
                count = 0;
            } else {
                last = last.next;
            }
            curr = last.next;
        }
        return curr;
    }

    private static ListNode createLoopNodeList(int[] id) {
        ListNode head = new ListNode(id[0]);
        ListNode node = head;
        for (int i = 1; i < id.length; i++) {
            ListNode newNode = new ListNode(id[i]);
            node.next = newNode;
            node = newNode;
        }
        node.next = head;
        return head;
    }
}
