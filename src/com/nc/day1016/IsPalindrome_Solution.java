package com.nc.day1016;

public class IsPalindrome_Solution {
    /**
     * @param x int整型
     * @return bool布尔型
     */
    public static boolean isPalindrome(int x) {
        String str = "" + x;
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        int x = -2147447412;
        boolean res = isPalindrome(x);
        System.out.println(res);
    }
}
