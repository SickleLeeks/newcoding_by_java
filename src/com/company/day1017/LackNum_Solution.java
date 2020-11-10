package com.company.day1017;

public class LackNum_Solution {
    /**
     * 找缺失数字
     *
     * @param a int整型一维数组 给定的数字串
     * @return int整型
     */
    public static int solve(int[] a) {
        if (a==null||a.length==0){
            return 0;
        }
        int start = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i]==start){
                start+=1;
            }else {
                return start;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 7};
        System.out.println(solve(arr));
    }
}
