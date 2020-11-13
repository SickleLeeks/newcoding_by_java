package com.company.day1025;

import java.util.*;

public class LRU_Solution {
//    static int size = 0;
//    static Stack<int[]> stack1 = new Stack<>();
//    static Stack<int[]> stack2 = new Stack<>();
//
//    /**
//     * lru design
//     *
//     * @param operators int整型二维数组 the ops
//     * @param k         int整型 the k
//     * @return int整型一维数组
//     */
//    public static int[] LRU(int[][] operators, int k) {
//        ArrayList<Integer> list = new ArrayList<>();
//        if (operators == null) {
//            return new int[0];
//        }
//        for (int i = 0; i < operators.length; i++) {
//            int[] oper = operators[i];
//            if (oper[0] == 1) {
//                int[] target = new int[]{oper[1], oper[2]};
//                if (size == k) {
//                    while (!stack1.isEmpty()) {
//                        stack2.push(stack1.pop());
//                    }
//                    stack2.pop();
//                    while (!stack2.isEmpty()) {
//                        if (stack2.peek()[0] != target[0]) {
//                            stack1.push(stack2.pop());
//                        }
//                    }
//                    stack1.push(target);
//                } else {
//                    while (!stack1.isEmpty()) {
//                        if (stack1.peek()[0] != target[0]) {
//                            stack2.push(stack1.pop());
//                        }
//                    }
//                    while (!stack2.isEmpty()) {
//                        stack1.push(stack2.pop());
//                    }
//                    stack1.push(target);
//                    size++;
//                }
//            }
//            if (oper[0] == 2) {
//                int res = -1;
//                while (!stack1.isEmpty()) {
//                    if (stack1.peek()[0] != oper[1]) {
//                        stack2.push(stack1.pop());
//                    } else {
//                        int[] target = stack1.pop();
//                        while (!stack2.isEmpty()) {
//                            stack1.push(stack2.pop());
//                        }
//                        res = target[1];
//                        stack1.push(target);
//                        break;
//                    }
//                }
//                list.add(res);
//            }
//        }
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i);
//        }
//        return res;
//    }

    public static void main(String[] args) {
        int[][] oper = new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int k = 3;
        System.out.println(Arrays.toString(LRU2(oper, k)));
    }

    static class DNode {
        DNode next;
        DNode prev;
        int key;
        int value;

        public DNode(int value) {
            this.value = value;
        }

        public DNode(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    static DNode head = new DNode(0);
    static DNode tail = new DNode(0);
    static int size = 0;
    static Map<Integer, DNode> map = new HashMap<>();
    static int capacity;

    public static int[] LRU2(int[][] operators, int k) {
        capacity = k;
        head.next = tail;
        tail.next = head;
        List<Integer> res = new ArrayList<>();
        for (int[] operator : operators) {
            if (operator[0] == 1) {
                set(operator[1], operator[2]);
            } else {
                int temp = get(operator[1]);
                res.add(temp);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int get(int key) {
        if (map.containsKey(key)) {
            DNode node = map.get(key);
            delete(node);
            moveToFirst(node);
            return node.value;
        } else {
            return -1;
        }
    }

    private static void set(int key, int value) {
        if (map.containsKey(key)) {
            DNode node = map.get(key);
            node.value = value;
            delete(node);
            moveToFirst(node);
        } else {
            if (size == capacity) {
                DNode last = tail.prev;
                delete(last);
                map.remove(last.key);
                size--;
            }
            DNode node = new DNode(key, value);
            map.put(key, node);
            size++;
            moveToFirst(node);
        }
    }

    private static void moveToFirst(DNode node) {
        DNode next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
    }

    private static void delete(DNode node) {
        DNode prev = node.prev;
        DNode next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
