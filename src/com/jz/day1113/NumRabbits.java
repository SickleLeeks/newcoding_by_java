package com.jz.day1113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Leetcode: 781 森林中的兔子
 */
public class NumRabbits {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(",");
        int[] answers = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        int res = numRabbits(answers);
        System.out.println(res);
    }

    public static int numRabbits(int[] answers) {
        int result = 0;
        if (answers == null || answers.length == 0) {
            return result;
        }
        Map<Integer, Integer> colors = new HashMap<>();
        for (int answer : answers) {
            if (answer == 0) {
                result += 1;
            } else if (!colors.containsKey(answer)) {
                result += (answer + 1);
                colors.put(answer, answer);
            } else {
                int tmp = colors.get(answer);
                if (tmp - 1 != 0) {
                    colors.put(answer, tmp - 1);
                } else {
                    colors.remove(answer);
                }
            }
        }
        return result;
    }
}
