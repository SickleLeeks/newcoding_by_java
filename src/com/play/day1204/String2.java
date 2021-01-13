package com.play.day1204;

//字符串转换
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
        int max = 0;
        for (char i = 'a'; i < 'z'; i++) {
            int curr = 0;
            int tmp = k;
            for (int j = 0; j < 26; j++) {
                for (int m = 0; m < s.length(); m++) {
                    if (Math.abs(s.charAt(m) - i) == j && tmp >= j) {
                        curr++;
                        tmp -= j;
                    }
                }
            }
            max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args) {
        int k = 10;
        String s = "acefxd";
        System.out.println(string2(k, s));
    }
}
