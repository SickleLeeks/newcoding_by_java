package com.jz.day1126;

import java.util.*;

/**
 * 1713. 得到子序列的最少操作次数
 */
public class MinOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int[] target = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            int[] array = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            System.out.println(minOperations0(target, array));
        }
        sc.close();
    }

    public static int minOperations0(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < n; i++) {
            position.put(target[i], i);
        }
        List<Integer> arrRef = new ArrayList<>();
        for (int val : arr) {
            if (position.containsKey(val)) {
                arrRef.add(position.get(val));
            }
        }
        Object[] arrCopy = arrRef.toArray();
        int maxUpSeqLen = lengthOfLIS(arrCopy);
        return target.length-maxUpSeqLen;
    }

    private static int lengthOfLIS(Object[] arrCopy) {
        if (arrCopy.length == 0) {
            return 0;
        }
        int[] dp = new int[arrCopy.length];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 0; i < arrCopy.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if ((int) arrCopy[i] > (int) arrCopy[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                maxLen = Math.max(dp[i], maxLen);
            }
        }
        return maxLen;
    }

    public static int minOperations(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < n; i++) {
            position.put(target[i], i);
        }
        List<Integer> arrRef = new ArrayList<>();
        for (int val : arr) {
            if (position.containsKey(val)) {
                int index = position.get(val);
                int it = binarySearch(arrRef, index);
                if (it != arrRef.size()) {
                    arrRef.set(it, index);
                } else {
                    arrRef.add(index);
                }
            }
        }
        return n - arrRef.size();
    }

    private static int binarySearch(List<Integer> list, int target) {
        int size = list.size();
        if (size == 0 || list.get(size - 1) < target) {
            return size;
        }
        int low = 0, high = size - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
