package com.jz.day1118;

import java.util.Arrays;
import java.util.Scanner;

public class GetLongestSubSeq {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] param = in.nextLine().split(" ");
        int N = Integer.parseInt(param[0]);
        int k = Integer.parseInt(param[1]);
        String[] arrstr = in.nextLine().split(" ");
        int[] arr = Arrays.stream(arrstr).mapToInt(Integer::parseInt).toArray();

//        System.out.println(solution(arr, k));
        System.out.println(solution2(arr, N, k));
    }

    private static int solution2(int[] arr, int n, int aim) {
        if (arr == null || arr.length == 0) return 0;
        int[] min_sum = new int[n];
        int[] min_index = new int[n];
        min_sum[n - 1] = arr[n - 1];
        min_index[n - 1] = n - 1;
        for (int i = n - 2; i > -1; i--) {
            if (min_sum[i + 1] <= 0) {
                min_sum[i] = arr[i] + min_sum[i + 1];
                min_index[i] = min_index[i + 1];
            } else {
                min_sum[i] = arr[i];
                min_index[i] = i;
            }
        }
        int sum_res = 0, max_length = 0, right = 0;
        for (int start = 0; start < n; start++) {
            while (right < n && sum_res + min_sum[right] <= aim) {
                sum_res += min_sum[right];
                right = min_index[right] + 1;
            }
            max_length = Math.max(max_length, right - start);
            sum_res -= right > start ? arr[start] : 0; // 如果当前start大于等于右边界，说明sum_res中没有值
            right = Math.max(right, start + 1);// start直接大于aim值，则扩不动
        }
        return max_length;
    }

    private static int solution(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;
        int sum = 0, length = 0;
        int[] help = new int[arr.length + 1];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i - 1];
            help[i] = Math.max(help[i - 1], sum);
        }
        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int pre = getLessIndex(help, sum - k, i);
            int templen = pre == -1 ? 0 : i - pre + 1;
            length = Math.max(length, templen);
        }
        return length;
    }

    private static int getLessIndex(int[] arr, int num, int index) {
        int left = 0, right = index;
        int res = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= num) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
