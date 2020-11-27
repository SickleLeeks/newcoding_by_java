package com.nc.day1005;

public class Judge_Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public static boolean judge(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int left = 0, right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "yamatomaya";
        System.out.println(judge(str));
    }

}
