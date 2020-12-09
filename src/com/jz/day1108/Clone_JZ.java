package com.jz.day1108;

import com.util.RandomListNode;

import java.util.HashMap;

public class Clone_JZ {
    /**
     * 复杂链表的复制
     *
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // target 作为将要返回的头
        RandomListNode target = new RandomListNode(pHead.label);
        // curr获取链表头
        RandomListNode curr = pHead;
        // p 获取新链表头
        RandomListNode p = target;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        // 由pHead将所有值存入map，每一个节点都要new的
        while (pHead != null) {
            map.put(pHead, new RandomListNode(pHead.label));
            pHead = pHead.next;
        }
        // target作为新链表的头，由curr和p移动来复制链表
        while (curr != null) {
            p.next = map.get(curr.next);
            p.random = map.get(curr.random);
            curr = curr.next;
            p = p.next;
        }
        return target;
    }
}
