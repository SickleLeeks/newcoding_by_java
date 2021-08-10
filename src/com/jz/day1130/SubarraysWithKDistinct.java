package com.jz.day1130;

import java.util.*;

/**
 * 992. K 个不同整数的子数组
 */
public class SubarraysWithKDistinct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] nums = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());
            System.out.println(subarraysWithKDistinct(nums, target));
        }
        sc.close();
    }

    public static int subarraysWithKDistinct(int[] A, int K) {
        int length = A.length;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> numCount = new LinkedHashMap<>();
        int count = 0;
        while (right < length) {
            int toAdd = A[right++];
            int windowsRightSamNum = 0;
            numCount.put(toAdd, numCount.getOrDefault(toAdd, 0) + 1);

            // 如果当前窗口中字母个数满足K，需要看当前窗口右侧连续位置上还有多少个字符和当前窗口中的字符相同
            if (numCount.size() == K) {
                windowsRightSamNum = calWindowRightSameNumCount(numCount, right, A);
            }

            // 当前窗口中的字符满足K，子数组个数总数+1；
            // 修正值需加上当前窗口右边和当前窗口中的字符相同的字符个数；
            // 左移窗口
            while (numCount.size() == K) {
                count += 1;
                count += windowsRightSamNum;
                updateWindowsValue(numCount, A[left++]);
            }
        }
        return count;
    }

    private static int calWindowRightSameNumCount(Map<Integer, Integer> numCount, int right, int[] A) {
        int countTmp = 0;
        for (int i = right; i < A.length; i++) {
            if (!numCount.containsKey(A[i])) {
                break;
            } else {
                countTmp += 1;
            }
        }
        return countTmp;
    }

    private static void updateWindowsValue(Map<Integer, Integer> numCount, int key) {
        if (numCount.get(key) == 1) {
            numCount.remove(key);
        } else {
            numCount.put(key, numCount.get(key) - 1);
        }
    }
}
