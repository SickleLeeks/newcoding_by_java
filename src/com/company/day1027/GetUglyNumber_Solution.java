package com.company.day1027;

/**
 * 丑数
 */
public class GetUglyNumber_Solution {
    public static int getUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] ugly = new int[index];
        ugly[0] = 1;
        int m2 = 0, m3 = 0, m5 = 0;
        int i = 1, min = 0;
        while (i < index) {
            min = Math.min(Math.min(ugly[m2] * 2, ugly[m3] * 3), ugly[m5] * 5);
            ugly[i] = min;
            while (ugly[m2] * 2 <= ugly[i]) {
                m2++;
            }
            while (ugly[m3] * 3 <= ugly[i]) {
                m3++;
            }
            while (ugly[m5] * 5 <= ugly[i]) {
                m5++;
            }
            i++;
        }
        return ugly[index - 1];
    }

    public static void main(String[] args) {
        int k = 7;
        System.out.println(getUglyNumber_Solution(k));
    }
}
