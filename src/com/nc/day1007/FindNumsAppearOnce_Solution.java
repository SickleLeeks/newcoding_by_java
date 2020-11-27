package com.nc.day1007;

public class FindNumsAppearOnce_Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        // 首先先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，表现的是A和B的不同的位
        int xor1 = 0;
        for (int i = 0; i < array.length; i++) {
            xor1 = xor1 ^ array[i];
        }
        // 在xor1中找到第一个不同的位对数据进行分类，分类为两个数组，然后分别对数组进行异或求和找到目标数字
        int index = 1;
        while ((index & xor1) == 0) {
            index = index << 1;
        }
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < array.length; i++) {
            if ((index & array[i]) == 0) {
                result1 = result1 ^ array[i];
            } else {
                result2 = result2 ^ array[i];
            }
        }
        num1[0] = result1;
        num2[0] = result2;
    }
}
