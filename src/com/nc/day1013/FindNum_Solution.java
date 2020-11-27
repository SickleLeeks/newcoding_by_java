package com.nc.day1013;

public class FindNum_Solution {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public static void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        num1 = new int[1];
        num2 = new int[1];
        if (array == null || array.length < 2) {
            return;
        }
        if (array.length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        // 计算所有元素的异或和
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            temp = temp ^ array[i];
        }
        // 找出temp的二进制表示中从低位开始的第一个等于1的位置
        int count = 0;
        while ((temp & (1 << count)) == 0) {
            count++;
        }
        // 等于1的位置，将所求的两个元素分到两个数组中，分别计算其异或和
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & (1 << count)) == 0) {
                num1[0] = num1[0] ^ array[i];
            } else {
                num2[0] = num2[0] ^ array[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        FindNumsAppearOnce(arr, null, null);
    }
}
