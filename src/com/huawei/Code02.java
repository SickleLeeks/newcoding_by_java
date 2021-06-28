package com.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Code02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        String[] powers = in.nextLine().split(" ");
        int minPower = Integer.parseInt(in.nextLine());
        int res = solution(N, powers, minPower);
        System.out.println(res);
    }

    public static int solution(int n, String[] powers, int minPower) {
        Integer[] powerlist = Arrays.stream(powers).map(Integer::parseInt).filter(x -> x < minPower).sorted().toArray(Integer[]::new);
        int res = n - powerlist.length;
        int i = 0, j = powerlist.length - 1;
        while (i < j) {
            if (powerlist[i] + powerlist[j] >= minPower) {
                res = res + 1;
                i = i + 1;
                j = j - 1;
            } else {
                i++;
            }
        }
        return res;
    }
}
