package com.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Code3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            int res = solution(str);
            System.out.println(res);
        }
        in.close();
    }

    public static int solution(String str) {
        if (str == null || str.length() <= 1 || isCharacter(str) || isDigital(str)) {
            return -1;
        }
        if (str.length() == 2) {
            if ((Character.isDigit(str.charAt(0)) && Character.isLetter(str.charAt(1))) ||
                    (Character.isLetter(str.charAt(0)) && Character.isDigit(str.charAt(1)))) {
                return 2;
            } else {
                return -1;
            }
        }
        char[] chars = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        for (int i = 0; i < chars.length; i++) {
            if (Character.isAlphabetic(chars[i])) {
                list.add(i);
            }
        }
        int res = -1;
        list.add(chars.length);
        for (int i = 0; i < list.size() - 2; ++i) {
            int gap = list.get(i + 2) - list.get(i);
            if (gap > 2) {
                res = Math.max(res, gap - 1);
            }
        }
        return res;
    }

    private static boolean isDigital(String str) {
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (!Character.isDigit(aChar)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCharacter(String str) {
        char[] chars = str.toCharArray();
        boolean flag = false;
        for (char aChar : chars) {
            flag = (aChar >= 'a' && aChar <= 'z') || (aChar >= 'A' && aChar <= 'Z');
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}
