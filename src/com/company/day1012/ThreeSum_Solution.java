package com.company.day1012;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ThreeSum_Solution {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        if (num == null || num.length < 3) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length - 2; i++) {
            for (int j = i + 1; j < num.length - 1; j++) {
                int target = 0 - num[i] - num[j];
                for (int k = j + 1; k < num.length; k++) {
                    if (num[k] == target) {
                        ArrayList<Integer> tmpList = new ArrayList<>();
                        tmpList.add(num[i]);
                        tmpList.add(num[j]);
                        tmpList.add(num[k]);
                        Collections.sort(tmpList);
                        if (!res.contains(tmpList)) {
                            res.add(tmpList);
                        }
                        break;
                    }
                }
            }
        }
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.get(0) > o2.get(0)) {
                    return 1;
                } else if (o1.get(0).equals(o2.get(0))) {
                    if (o1.get(1) > o2.get(1)) {
                        return 1;
                    } else if (o1.get(1).equals(o2.get(1))) {
                        if (o1.get(2) > o2.get(2)) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });
        return res;
    }


    public static void main(String[] args) {
        int[] S = new int[]{-13, 5, 13, 12, -2, -11, -1, 12, -3, 0, -3, -7, -7, -5, -3, -15, -2, 14, 14, 13, 6, -11, -11, 5, -15, -14, 5, -5, -2, 0, 3, -8, -10, -7, 11, -5, -10, -5, -7, -6, 2, 5, 3, 2, 7, 7, 3, -10, -2, 2, -12, -11, -1, 14, 10, -9, -15, -8, -7, -9, 7, 3, -2, 5, 11, -13, -15, 8, -3, -7, -12, 7, 5, -2, -6, -3, -10, 4, 2, -5, 14, -3, -1, -10, -3, -14, -4, -3, -7, -4, 3, 8, 14, 9, -2, 10, 11, -10, -4, -15, -9, -1, -1, 3, 4, 1, 8, 1};
        ArrayList<ArrayList<Integer>> res = threeSum(S);
        for (ArrayList<Integer> item : res) {
            System.out.println(item);
        }
    }
}
