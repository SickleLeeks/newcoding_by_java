package com.jz.day1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 单链表的选择排序
 */
public class SingleLinkSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        Node root = new Node(-1);
        Node head = root;
        for (int i = 0; i < line.length; i++) {
            Node node = new Node(Integer.parseInt(line[i]));
            head.next = node;
            head = node;
        }
        Node res = singleLinkSort(root.next);
        while (res != null) {
            System.out.print(res.value + " ");
            res = res.next;
        }
    }

    private static Node singleLinkSort(Node head) {
        Node tail = null; // 排序部分的尾部
        Node curr = head; //未排序部分的头部
        Node smallPre = null; //最小节点的前一个节点
        Node small = null; //最小的节点
        while (curr != null) {
            small = curr;
            smallPre = getSmallestPreNode(curr);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            curr = curr == small ? curr.next : curr;
            if (tail == null) {
                head = small;
            } else {
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }

    private static Node getSmallestPreNode(Node head) {
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.value < small.value) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}

