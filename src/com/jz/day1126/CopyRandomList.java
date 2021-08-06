package com.jz.day1126;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

/**
 * 138. 复制带随机指针的链表
 */
public class CopyRandomList {
    Map<Node, Node> cachedMap = new HashMap<>();

    // 方法1：哈希表+回溯法
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedMap.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedMap.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedMap.get(head);
    }

    // 方法2：迭代法+链表拆分
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = node.next;
            newNode.random = (node.random != null) ? node.random.next : null;
        }
        Node newHead = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node newNode = node.next;
            node.next = node.next.next;
            newNode.next = (newNode.next != null) ? newNode.next.next : null;
        }
        return newHead;
    }
}
