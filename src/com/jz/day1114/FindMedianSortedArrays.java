package com.jz.day1114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Leetcode: 4: 寻找两个正序数组的中位数
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(",");
        int[] num1 = Arrays.stream(str1).mapToInt(Integer::parseInt).toArray();
        String[] str2 = br.readLine().split(",");
        int[] num2 = Arrays.stream(str2).mapToInt(Integer::parseInt).toArray();
        double res = findMedianSortedArrays(num1, num2);
        System.out.println(res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 == 0 || n2 == 0) {
            int[] num = n1 == 0 ? nums2 : nums1;
            int n = n1 == 0 ? n2 : n1;
            if (n % 2 == 0) {
                return (num[n / 2] + num[n / 2 - 1]) / 2.0;
            } else {
                return num[n / 2] * 1.0;
            }
        }
        int[] combine = new int[n1 + n2];
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                combine[k] = nums1[i];
                i++;
                k++;
            } else {
                combine[k] = nums2[j];
                j++;
                k++;
            }
        }
        if (i == n1) {
            while (j < n2) {
                combine[k] = nums2[j];
                k++;
                j++;
            }
        }
        if (j == n2) {
            while (i < n1) {
                combine[k] = nums1[i];
                k++;
                i++;
            }
        }
        int midIndex = combine.length;
        if (midIndex % 2 == 0) {
            return (combine[midIndex / 2] + combine[midIndex / 2 - 1]) / 2.0;
        } else {
            return combine[midIndex / 2] * 1.0;
        }
    }
}
