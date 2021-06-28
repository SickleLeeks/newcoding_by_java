package com.jz.day1118;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSumStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] param = in.nextLine().split(" ");
        String[] nums = in.nextLine().split(" ");
        int N = Integer.parseInt(param[0]);
        int k = Integer.parseInt(param[1]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(nums[i]);
        }
        int res = solution(arr, k);
        int res2 = solution2(arr, k);
        System.out.println(res);
        System.out.println(res2);
    }

    private static int solution2(int[] arr, int aim) {
        if (arr == null || arr.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - aim)) {
                res = Math.max(res, i - map.get(sum - aim));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return res;
    }

    //数组元素全为正数
    private static int solution(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k < 0) {
            return 0;
        }
        int L = 0, R = 0;
        int res = 0, sum = arr[0];
        while (R < arr.length) {
            if (sum == k) {
                res = Math.max(res, R - L + 1);
                sum -= arr[L++];
            } else if (sum < k) { //小于等于，右边界往右边扩
                if (++R == arr.length) break;
                sum += arr[R];
            } else { //大于， 左边界往右边扩
                sum -= arr[L++];
            }
        }
        return res;
    }
}
