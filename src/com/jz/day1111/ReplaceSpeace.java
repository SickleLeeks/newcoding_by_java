package com.jz.day1111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 替换空格
 */
public class ReplaceSpeace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String res = replaceSpace(str);
        System.out.println(res);
    }

    public static String replaceSpace(String s) {
        // write code here
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] strs = s.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (" ".equals(strs[i])) {
                sb.append("%20");
            } else {
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }
}
