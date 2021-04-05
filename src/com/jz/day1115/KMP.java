package com.jz.day1115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * KMP问题
 */
public class KMP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        int res = kmp(S, T);
        System.out.println(res);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算模板串S在文本串T中出现了多少次
     *
     * @param S string字符串 模板串
     * @param T string字符串 文本串
     * @return int整型
     */
    public static int kmp(String S, String T) {
        // write code here
        if (S == null || T == null || S.length() > T.length()) {
            return 0;
        }
        int n1 = S.length();
        int n2 = T.length();
        int res = 0;
        for (int i = 0; i < n2 - n1 + 1; i++) {
            if (T.substring(i, i + n1).equals(S)) {
                res++;
            }
        }
        return res;
    }
}
