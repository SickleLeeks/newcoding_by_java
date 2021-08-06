package com.jz.day1127;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Leetcode 1104. 二叉树寻路
 */
public class PathInZigZagTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int label = Integer.parseInt(sc.nextLine());
            List<Integer> res = pathInZigZagTree(label);
            System.out.println(res.toString());
        }
    }

    public static List<Integer> pathInZigZagTree(int label) {
        // 计算label所在的层级
        int n = (int) Math.ceil(Math.log10(label + 1) / Math.log10(2));
        int[] res = new int[n];
        int index = n - 1, curr = label;
        while (index >= 0) {
            res[index--] = curr; // 最后一个元素为当前数值
            int total = (int) Math.pow(2, n - 1); // 当前层的元素个数
            int start = (int) Math.pow(2, n - 1); // 当前层的起始元素标号
            int end = (int) Math.pow(2, n - 1) + total - 1; // 当前层的结束元素标号
            if (n % 2 == 0) {
                //如果是偶数层，则当前层节点从右向左数值递增，相应的计算上一层下标也应该从右往左
                int j = total / 2; // 记录上一层元素的最大偏移量
                for (int i = start; i <= end; i += 2, j--) { // 得到当前元素所属的上一层的偏移量
                    if (i == curr || (i + 1) == curr) break;
                }
                int preStart = (int) Math.pow(2, n - 1 - 1);// 上一层的起始下标
                while (j-- > 1) {
                    preStart++;
                }
                curr = preStart;
            } else {
                // 当前层为奇数层，则当前层序号从左到右递增，相应计算上一层下标也应该是从左到右
                int j = 1;// 上一层给元素最小偏移量，从1开始
                for (int i = start; i <= end; i += 2, j++) {
                    if (i == curr || (i + 1) == curr) break;
                }
                int prevEnd = 2 * (int) Math.pow(2, n - 1 - 1) - 1; // 上一层的结束下标
                while (j-- > 1) {
                    prevEnd--;
                }
                curr = prevEnd;
            }
            n--;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : res) {
            list.add(i);
        }
        return list;
    }

    public static List<Integer> pathInZigZagTree2(int label) {
        // 计算label所在的层级
        int n = (int) Math.ceil(Math.log10(label + 1) / Math.log10(2));
        int[] res = new int[n];
        int index = n - 1, curr = label;
        while (index >= 0) {
            res[index--] = curr;
            int located = ((1 << (n)) - 1 - curr) >> 1; // 相对位置
            curr = (1 << (n - 2)) + located; //上一层对应元素下标
            n--;
        }
        List<Integer> list = new ArrayList<>();
        for (int i : res) list.add(i);
        return list;
    }
}
