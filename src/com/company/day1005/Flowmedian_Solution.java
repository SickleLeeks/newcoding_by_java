package com.company.day1005;

import java.util.*;

public class Flowmedian_Solution {
    /**
     * 随时找出数据流的中位数：最大堆和最小堆
     *
     * @param operations
     * @return
     */
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxHeapComparator());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinHeapComparator());

    private static class MaxHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    private static class MinHeapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    public static double[] flowmedian(int[][] operations) {
        int len = operations.length;
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (operations[i][0] == 1) {
                addToHeap(operations[i][1]);
            }
            if (operations[i][0] == 2) {
                res.add(getMedianFromHeap());
            }
        }
        return res.stream().mapToDouble(Double::doubleValue).toArray();
    }

    // 从两个堆中获取中位数
    public static double getMedianFromHeap() {
        // 堆中元素为空时，返回-1
        int maxHeapSize = maxHeap.size();
        int minHeapSize = minHeap.size();
        if (maxHeapSize + minHeapSize == 0) {
            return -1;
        }
        // 计算中位数
        Integer maxHeapHead = maxHeap.peek();
        Integer minHeapHead = minHeap.peek();
        if (((maxHeapSize + minHeapSize) & 1) == 0) {
            return (maxHeapHead + minHeapHead) / 2.0;
        }
        return maxHeapSize > minHeapSize ? maxHeapHead : minHeapHead;
    }

    /**
     * 将元素添加到两个堆中
     *
     * @param num
     */
    // 插入元素到两个堆中【关键】
    public static void addToHeap(int num) {
        // 保证最大堆中元素始终小于最小堆中的元素
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        if (maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            if (minHeap.isEmpty()) {
                minHeap.add(num);
                return;
            }
            if (minHeap.peek() > num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
        }
        modifyTwoHeapsSize();
    }

    // 维持两个堆的高度差不超过1
    private static void modifyTwoHeapsSize() {
        while (maxHeap.size() - minHeap.size() >= 2) {
            minHeap.add(maxHeap.poll());
        }
        while (minHeap.size() - maxHeap.size() >= 2) {
            maxHeap.add(minHeap.poll());
        }
    }

    /**
     * the medians
     *
     * @param operations int整型二维数组 ops
     * @return double浮点型一维数组
     */
    public static double[] myflowmedian(int[][] operations) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Double> res = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i][0] == 1) {
                list.add(operations[i][1]);
            }
            if (operations[i][0] == 2) {
                if (list.size() == 0) {
                    res.add((double) -1);
                } else if (list.size() == 1) {
                    res.add(list.get(0) * 1.0);
                } else if (list.size() == 2) {
                    res.add((list.get(0) + list.get(1)) / 2.0);
                } else {
                    Collections.sort(list);
                    int L = list.size();
                    if (L % 2 != 0) {
                        res.add(list.get(L / 2) * 1.0);
                    } else {
                        res.add((list.get(L / 2) + list.get(L / 2 - 1)) / 2.0);
                    }
                }
            }
        }
        double[] result = res.stream().mapToDouble(Double::doubleValue).toArray();
        return result;
    }

    public static void main(String[] args) {
        int[][] oper = new int[][]{{1, 5}, {2}, {1, 3}, {2}, {1, 6}, {2}, {1, 7}, {2}};
        int[][] oper2 = new int[][]{{2}, {1, 1}, {2}};
        System.out.println(Arrays.toString(flowmedian2(oper)));
    }

    /**
     * 随时找到数据流的中位数
     *
     * @param operations
     * @return
     */
    // 通过率 100%
    public static double[] flowmedian2(int[][] operations) {
        ArrayList<Double> arr = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int[] oper : operations) {
            if (oper[0] == 1) {
                if (maxHeap.isEmpty() || maxHeap.peek() > oper[1]) {
                    maxHeap.add(oper[1]);
                } else {
                    minHeap.add(oper[1]);
                }
                if (minHeap.size() == maxHeap.size() + 2) {
                    maxHeap.add(minHeap.poll());
                }
                if (maxHeap.size() == minHeap.size() + 2) {
                    minHeap.add(maxHeap.poll());
                }
            } else {
                if (maxHeap.size() == 0) {
                    double ans = -1;
                    arr.add(ans);
                    continue;
                }
                if (maxHeap.size() == minHeap.size()) {
                    double num1 = maxHeap.peek();
                    double num2 = minHeap.peek();
                    arr.add((num1 + num2) / 2);
                } else {
                    if (maxHeap.size() > minHeap.size()) {
                        double num1 = maxHeap.peek();
                        arr.add(num1);
                    } else {
                        double num2 = minHeap.peek();
                        arr.add(num2);
                    }
                }
            }
        }
        return arr.stream().mapToDouble(Double::doubleValue).toArray();
    }
}
