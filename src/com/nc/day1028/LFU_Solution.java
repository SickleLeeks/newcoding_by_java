package com.nc.day1028;

import java.util.*;

/**
 * LFU缓存结果设计
 */


public class LFU_Solution {
    static class LFUCache {

        class Node {
            int key;
            int val;
            int frq;

            public Node() {
            }

            public Node(int key, int val, int frq) {
                this.key = key;
                this.val = val;
                this.frq = frq;
            }
        }

        private int CAPACITY;
        private Map<Integer, Node> map = new HashMap<>();
        private Map<Integer, LinkedList<Node>> freqMap = new HashMap<>();
        private int minFreq;

        public LFUCache(int capacity) {
            this.CAPACITY = capacity;
            this.minFreq = 1;
        }

        public void update(Node node) {
            LinkedList<Node> list = freqMap.get(node.frq);
            list.remove(node);
            if (list.isEmpty() && node.frq == minFreq) {
                minFreq++;
            }
            node.frq++;
            if (!freqMap.containsKey(node.frq)) {
                freqMap.put(node.frq, new LinkedList<>());
            }
            freqMap.get(node.frq).addLast(node);
        }

        public int get(int k) {
            if (!map.containsKey(k)) {
                return -1;
            }
            Node node = map.get(k);
            update(node);
            return node.val;
        }

        public void put(int k, int v) {
            if (map.containsKey(k)) {
                Node node = map.get(k);
                node.val = v;
                update(node);
                map.put(k, node);
                return;
            }
            if (map.size() == CAPACITY) {
                Node node = freqMap.get(minFreq).removeFirst();
                map.remove(node.key);
            }
            Node node = new Node(k, v, 1);
            map.put(k, node);
            if (!freqMap.containsKey(1)) {
                freqMap.put(1, new LinkedList<>());
            }
            freqMap.get(1).addLast(node);
            minFreq = 1;
        }
    }

    /**
     * lfu design
     *
     * @param operators int整型二维数组 ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public static int[] LFU(int[][] operators, int k) {
        LFUCache cache = new LFUCache(k);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                cache.put(operators[i][1], operators[i][2]);
            } else {
                res.add(cache.get(operators[i][1]));
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
/*    static int K = 0;
    static Map<Integer, int[]> map = new LinkedHashMap<>();
    static Deque<Integer> order = new ArrayDeque<>();

    public static int[] LFU(int[][] operators, int k) {
        if (operators == null || k <= 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        K = k;
        for (int i = 0; i < operators.length; i++) {
            int oper = operators[i][0];
            if (oper == 1) {
                int x = operators[i][1];
                int y = operators[i][2];
                set(x, y);
            } else if (oper == 2) {
                int x = operators[i][1];
                list.add(get(x));
            } else {
                return null;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void set(int key, int value) {
        if (map.containsKey(key)) {
            int[] temp = map.get(key);
            map.put(key, new int[]{value, temp[1] + 1});
            modify(key);
        } else {
            if (map.size() == K) {
                remove(map);
            }
            map.put(key, new int[]{value, 1});
            order.addLast(key);
        }
    }

    private static void modify(int key) {
        Deque<Integer> tempqueue = new ArrayDeque<>();
        while (order.peekFirst() != key) {
            tempqueue.addLast(order.pollFirst());
        }
        order.addLast(order.pollFirst());
        while (!tempqueue.isEmpty()) {
            order.addFirst(tempqueue.pollLast());
        }
    }

    private static void remove(Map<Integer, int[]> map) {
        int key = order.poll();
        map.keySet().removeIf(temp -> key == temp);
    }

    public static int get(int key) {
        if (map.containsKey(key)) {
            modify(key);
            int[] temp = map.get(key);
            map.put(key, new int[]{temp[0], temp[1] + 1});
            return temp[0];
        } else {
            return -1;
        }
    }*/

    public static void main(String[] args) {
        int[][] operators = new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {1, 2, 4}, {1, 3, 5}, {2, 2}, {1, 4, 4}, {2, 1}};
        int k = 3;
        System.out.println(Arrays.toString(LFU(operators, k)));
    }
}
