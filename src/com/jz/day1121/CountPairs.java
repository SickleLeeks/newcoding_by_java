package com.jz.day1121;

import java.util.*;

/**
 * Leetcode1711 大餐计数
 */
public class CountPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split(",");
            int[] deliciousness = Arrays.stream(str).mapToInt(Integer::parseInt).toArray();
            System.out.println(countPairs2(deliciousness));
        }
        sc.close();
    }

    private static int countPairs(int[] deliciousness) {
        if (deliciousness == null || deliciousness.length == 0) {
            return 0;
        }
        Arrays.sort(deliciousness);
        HashMap<Integer, Integer> kvCount = new HashMap<>();
        HashMap<Integer, HashSet<String>> pairs = new HashMap<>();
        for (int k : deliciousness) {
            if (!kvCount.containsKey(k)) {
                kvCount.put(k, 1);
            } else {
                kvCount.put(k, kvCount.get(k) + 1);
            }
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = i + 1; j < deliciousness.length; j++) {
                int sum = deliciousness[i] + deliciousness[j];
                maxSum = Math.max(maxSum, sum);
                if (!pairs.containsKey(sum)) {
                    HashSet<String> strSet = new HashSet<>();
                    strSet.add(deliciousness[i] + "_" + deliciousness[j]);
                    pairs.put(sum, strSet);
                } else {
                    HashSet<String> strSet = pairs.get(sum);
                    strSet.add(deliciousness[i] + "_" + deliciousness[j]);
                    pairs.put(sum, strSet);
                }
            }
        }
        int maxPow = (int) log(maxSum);
        int res = 0;
        for (int i = 0; i <= maxPow; i++) {
            int target = (int) Math.pow(2, i);
            if (pairs.containsKey(target)) {
                HashSet<String> strSet = pairs.get(target);
                for (String str : strSet) {
                    int[] pair = Arrays.stream(str.split("_")).mapToInt(Integer::parseInt).toArray();
                    if (pair[0] == pair[1]) {
                        res += (kvCount.get(pair[0]) * (kvCount.get(pair[1]) - 1)) / 2;
                    } else {
                        res += (kvCount.get(pair[0]) * kvCount.get(pair[1]));
                    }
                }
            }
        }
        return res;
    }

    private static double log(int n) {
        return Math.log(n) / Math.log(2);
    }

    private static int countPairs2(int[] deliciousness) {
        final int MOD = 1000000007;
        int maxValue = 0;
        for (int val : deliciousness) {
            maxValue = Math.max(maxValue, val);
        }
        int maxSum = maxValue * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MOD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }
}
