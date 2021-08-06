package com.jz.day1124;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Leetcode 274 H指数II
 */
public class HIndexII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] citions = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            System.out.println(hIndexII(citions));
        }
        sc.close();
    }

    public static int hIndexII(int[] citations) {
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }
}
