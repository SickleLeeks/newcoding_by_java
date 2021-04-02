package com.jz.day1111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchMinElement {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(bufferedReader.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = array.length;
        int result = searchMinElement(array, 0, n - 1, 0);
        System.out.println(result);
    }

    private static int searchMinElement(int[] array, int left, int right, int mid) {
        while (left < right) {
            mid = left + (right - left + 1) / 2;
            if (array[mid] < array[mid - 1] || array[mid] > array[mid + 1]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return array[left];
    }
}
