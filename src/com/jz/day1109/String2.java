package com.jz.day1109;

public class String2 {
    /**
     * @param k int整型 表示最多的操作次数
     * @param s string字符串 表示一个仅包含小写字母的字符串
     * @return int整型
     */
    // 暴力枚举法
    public static int string2(int k, String s) {
        if ("".equals(s) || k <= 0) {
            return 0;
        }
        int[] num = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            num[i] = s.charAt(i) - 'a';
        }
        int i = 0, max = Integer.MIN_VALUE;
        while (i < 26) {
            int count = 0,tmp = k;
            for (int j = 0; j < num.length; j++) {
                if (num[j] != i && count + Math.abs(num[j] - i) < k) {
                    count++;
                }
            }
            if (count > max) {
                max = count + 1;
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        int k = 10;
        String s = "acefxd";
        System.out.println(string2(k, s));
    }
}
