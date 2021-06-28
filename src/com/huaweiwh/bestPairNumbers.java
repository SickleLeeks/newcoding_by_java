package com.huaweiwh;

import java.util.*;

public class bestPairNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] numStr = sc.nextLine().split(",");
            int res = Solution(numStr);
            System.out.println(res);
        }
        sc.close();
    }

    private static int Solution(String[] numStr) {
        if (numStr.length == 0) {
            return 0;
        }
        int[] nums = Arrays.stream(numStr).mapToInt(Integer::parseInt).toArray();
        Map<Integer, Integer> elementCount = new HashMap<>();
        for (int num : nums) {
            if (elementCount.containsKey(num)) {
                elementCount.put(num, elementCount.get(num) + 1);
            } else {
                elementCount.put(num, 1);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> item : elementCount.entrySet()) {
            if (item.getValue() >= 2) {
                res += (item.getValue() * (item.getValue() - 1)) / 2;
            }
        }
        return res;
    }
}
