package com.jz.day1119;

import java.util.Scanner;

public class RemoveSameChar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            int res = solution(str);
            System.out.println(res);
        }
    }

    private static int solution(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        if (str.length() == 1) {
            return 1;
        }
        if (str.length()==2){
            return str.charAt(0)==str.charAt(1)?0:1;
        }
        StringBuilder tmp = new StringBuilder();
        tmp.append(str.charAt(0));
        int i = 1;
        while (i < str.length()) {
            if (tmp.charAt(tmp.length() - 1) != str.charAt(i)) {
                tmp.append(str.charAt(i));
            } else {
                tmp.deleteCharAt(tmp.length() - 1);
            }
            i = i + 1;
        }
        return tmp.length();
    }
}
