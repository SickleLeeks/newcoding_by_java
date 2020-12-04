package com.nc.day1006;

import com.util.ListNode;

import java.util.Stack;

public class AddInList_Solution {
    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public static ListNode addInList(ListNode head1, ListNode head2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> resstack = new Stack<>();
        while (head1 != null) {
            stack1.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }
        int tmp = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = tmp + stack1.pop().val + stack2.pop().val;
            tmp = sum / 10;
            resstack.push(new ListNode(sum % 10));
        }
        while (!stack1.isEmpty()) {
            int sum = tmp + stack1.pop().val;
            tmp = sum / 10;
            resstack.push(new ListNode(sum % 10));
        }
        while (!stack2.isEmpty()) {
            int sum = tmp + stack2.pop().val;
            tmp = sum / 10;
            resstack.push(new ListNode(sum % 10));
        }
        if (tmp != 0) {
            resstack.push(new ListNode(tmp));
        }
        ListNode head = resstack.pop();
        ListNode point = head;
        while (!resstack.isEmpty()) {
            point.next = resstack.pop();
            point = point.next;
        }
        return head;
    }

    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public static ListNode myaddInList(ListNode head1, ListNode head2) {
        int num1 = 0, num2 = 0;
        while (head1 != null) {
            if (head1.val == 0 && num1 == 0) {
                head1 = head1.next;
            }
            num1 = num1 * 10 + head1.val;
            head1 = head1.next;
        }
        while (head2 != null) {
            if (head2.val == 0 && num2 == 0) {
                head2 = head2.next;
            }
            num2 = num2 * 10 + head2.val;
            head2 = head2.next;
        }
        String value = String.valueOf(num1 + num2);
        ListNode head = new ListNode(Integer.parseInt(String.valueOf(value.charAt(0))));
        int i = 1;
        ListNode point = head;
        while (i < value.length()) {
            point.next = new ListNode(Integer.parseInt(String.valueOf(value.charAt(i))));
            point = point.next;
            i++;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(7);

        head1.next = node1;
        node1.next = node2;

        ListNode head2 = new ListNode(6);
        ListNode node3 = new ListNode(3);
        head2.next = node3;

        ListNode res = addInList(head1, head2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
