package com.jz.day1119;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

class HeapNode {
    int idx1; // arr1中的位置
    int idx2; // arr2中的位置
    int sum; // arr1[index1]+arr2[index2]

    public HeapNode(int idx1, int idx2, int sum) {
        this.idx1 = idx1;
        this.idx2 = idx2;
        this.sum = sum;
    }
}

/**
 * 两个有序数组间相加和的TOP K问题
 */
public class TwoArrayTopK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] param = sc.nextLine().split(" ");
        int N = Integer.parseInt(param[0]);
        int K = Integer.parseInt(param[1]);
        String[] arr1 = sc.nextLine().split(" ");
        String[] arr2 = sc.nextLine().split(" ");
        int[] res = solution(N, K, arr1, arr2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    private static int[] solution(int n, int k, String[] arr1, String[] arr2) {
        if (arr1 == null || arr2 == null || k < 1) {
            return null;
        }
        int[] nums1 = Arrays.stream(arr1).mapToInt(Integer::parseInt).sorted().toArray();
        int[] nums2 = Arrays.stream(arr2).mapToInt(Integer::parseInt).sorted().toArray();
        k = Math.min(k, n * n); // 数组求和最多有n*n种组合，如果k较大，则所有组合都会输出
        int[] res = new int[k];
        int resIndex = 0;
        //自定义比较器，实现大根堆
        PriorityQueue<HeapNode> maxHeap = new PriorityQueue<>((N1, N2) -> N2.sum - N1.sum);
        HashSet<String> positionSet = new HashSet<>(); //使用hashset解决超内存问题
        // 从右下角开始
        int index1 = nums1.length - 1;
        int index2 = nums2.length - 1;
        maxHeap.add(new HeapNode(index1, index2, nums1[index1] + nums2[index2]));
        positionSet.add(index1 + "_" + index2);
        while (resIndex < k) {
            HeapNode curr = maxHeap.poll();
            res[resIndex++] = curr.sum;
            index1 = curr.idx1;
            index2 = curr.idx2;
            if (index1 - 1 >= 0 && !positionSet.contains((index1 - 1) + "_" + index2)) {
                positionSet.add(index1 - 1 + "_" + index2);
                maxHeap.add(new HeapNode(index1 - 1, index2, nums1[index1 - 1] + nums2[index2]));
            }
            if (index2 - 1 >= 0 && !positionSet.contains(index1 + "_" + (index2 - 1))) {
                positionSet.add(index1 + "_" + (index2 - 1));
                maxHeap.add(new HeapNode(index1, index2 - 1, nums1[index1] + nums2[index2 - 1]));
            }
        }
        return res;
    }
}
