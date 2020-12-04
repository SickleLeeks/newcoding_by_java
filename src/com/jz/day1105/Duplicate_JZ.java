package com.jz.day1105;

import java.util.HashSet;
import java.util.Set;

public class Duplicate_JZ {
    /**
     * 数组中重复的数字
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (!set.contains(numbers[i])) {
                set.add(numbers[i]);
            } else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 3, 1, 0, 2, 5, 3};
        int length = 7;
        int[] duplication = new int[1];
        System.out.println(duplicate(numbers, length, duplication));
    }
}
