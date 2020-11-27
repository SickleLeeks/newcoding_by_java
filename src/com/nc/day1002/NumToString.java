package com.nc.day1002;

/**
 * 把数字翻译成字符串
 */
public class NumToString {
    /**
     * 解码
     *
     * @param nums string字符串 数字串
     * @return int整型
     */
    public static int solve(String nums) {
        if (nums == null || nums.equals("")) {
            return 0;
        }
        char[] chrs = nums.toCharArray();
        return process(chrs, 0);
    }

    private static int process(char[] chrs, int i) {
        if (i == chrs.length) {
            return 1;
        }
        if (chrs[i] == '0') {
            return 0;
        }
        int res = process(chrs, i + 1);
        if (i + 1 < chrs.length && (chrs[i] - '0') * 10 + chrs[i + 1] - '0' < 27) {
            res += process(chrs, i + 2);
        }
        return res;
    }

    public static void main(String[] args) {
        String num = "31717126241541717";
        System.out.println(solve(num));
    }
}
