package com.jz.day1102;

import java.util.*;

public class MedianOfStream_JZ {
    /**
     * 数据流中的中位数
     *
     * @param num
     */
    // 方法1
    ArrayList<Integer> array = new ArrayList<>();

    public void Insert(Integer num) {
        array.add(num);
    }

    public Double GetMedian() {
        Collections.sort(array);
        int index = array.size() / 2;
        if (array.size() % 2 != 0) {// 奇数直接取
            return (double) array.get(index);
        }
        return (array.get(index - 1) + array.get(index)) / 2.0;
    }

    // 方法2
    private List<Integer> list = new LinkedList<>();

    public void Insert2(Integer num) {
        if (list.size() == 0) {
            list.add(num);
            return;
        }
        int first = 0;
        int last = list.size() - 1;
        int mid = 0;
        while (first < last) {
            mid = first + (last - first) / 2;
            if (list.get(mid) > num) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }
        list.add(first, num);
        return;
    }

    public Double GetMedian2() {
        int index = list.size();
        if (index % 2 == 1) {
            return (double) list.get(index / 2);
        }
        return ((double) list.get(index / 2 - 1) + (double) list.get(index / 2)) / 2;
    }

    // 方法3
    private TreeSet<Integer> tree = new TreeSet<>();

    public void Insert3(Integer num) {
        tree.add(num);
    }

    public Double GetMedian3() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(tree);
        int index = list.size();
        if (index % 2 == 1) {
            return (double) list.get(index / 2);
        }
        return ((double) list.get(index / 2 - 1) + (double) list.get(index / 2)) / 2;
    }

    // 方法4
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    int count = 0;

    public void Insert4(Integer num) {
        // 个数为偶数，则先插入大顶堆，并调整，然后将大顶堆中的最大数插入到小顶堆中
        if (count % 2 == 0) {
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        } else {
            //个数为奇数时，则先插入小顶堆，然后将小顶堆中最小的数插入到大顶堆中
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double GetMedian4() {
        // 当前为偶数个，则取大顶堆和小顶堆的堆顶元素的平均值
        if (count % 2 == 0) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            // 当前为奇数个，则直接从小顶堆中取元素即可，所以保证小顶堆中元素的个数
            return minHeap.peek() * 1.0;
        }
    }
}
