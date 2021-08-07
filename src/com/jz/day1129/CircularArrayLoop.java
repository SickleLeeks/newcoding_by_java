package com.jz.day1129;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 457. 环形数组是否存在循环
 */
public class CircularArrayLoop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            System.out.println(circularArrayLoop(nums));
        }
        sc.close();
    }

    // 模拟
    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (check(i, nums, n)) return true;
        }
        return false;
    }

    private static boolean check(int start, int[] nums, int n) {
        int curr = start;
        boolean flag = nums[start] > 0;
        int k = 1;
        while (true) {
            if (k > n) return false;
            int next = ((curr + nums[curr]) % n + n) % n;
            if (flag && nums[next] < 0) return false;
            if (!flag && nums[next] > 0) return false;
            if (next == start) return k > 1;
            curr = next;
            k++;
        }
    }

    // 图遍历标记
    public static boolean circularArrayLoop2(int[] nums) {
        int OFFSET = 1000000;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= OFFSET) continue;
            int curr = i, tag = OFFSET + i, last = -1;
            boolean flag = nums[curr] > 0; // 方向
            while (true) {
                int next = ((curr + nums[curr]) % n + n) % n;
                last = nums[curr]; // 向后遍历
                nums[curr] = tag;
                curr = next;
                if (curr == i) break;
                if (nums[curr] >= OFFSET) break;
                if (flag && nums[curr] < 0) break;
                if (!flag && nums[curr] > 0) break;
            }
            if (last % n != 0 && nums[curr] == tag) return true;
        }
        return false;
    }
}
