package com.jz.day1124;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Leetcode 274 H指数
 */
public class HIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] citions = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            System.out.println(hIndex(citions));
        }
        sc.close();
    }

    /**
     * 排序
     *
     * @param citations
     * @return
     */
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        // 如果当前文章的引用数大于h，则h加1，直到至少有n-h篇论文每篇被引用次数不超过h次
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    /**
     * 计数排序
     *
     * @param citations
     * @return
     */
    public static int hIndex2(int[] citations) {
        int n = citations.length, tot = 0;
        int[] count = new int[n + 1];
        //索引表示引用次数，值表示文章数
        for (int i = 0; i < n; i++) {
            // 如果当前引用次数超过论文发表篇数，则直接将最后一个索引位置加1
            if (citations[i] >= n) {
                count[n]++;
            } else {
                count[citations[i]]++;
            }
        }
        for (int i = n; i >= 0; i--) {
            tot += count[i];
            // 如果当前有tot篇论文分别被引用至少i次，则返回该H值。
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }

}
