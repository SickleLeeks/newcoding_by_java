package com.jz.day1101;

public class Add_JZ {
    /**
     * 不用加减乘除做加法
     * 1. 计算a和b的无进位和，和进位
     * 2. 如果进伟不为0，则说明a+b的结果等于无进位和+进位，此时，把无进位和作为a，进位作为b，继续计算
     * 3. 计算进位等于0，说明此时a+b的结果就等于无进位和，返回无进位和即可。
     *
     * @param num1
     * @param num2
     * @return
     */
    public static int Add(int num1, int num2) {
        while (num2 != 0) {
            // 负数左移会在低位补1，所以转化位无符号整数
            int c = (num1 & num2) << 1;
            num1 ^= num2;
            num2 = c;
        }
        return num1;
    }

    public static void main(String[] args) {
        int num1 = 18;
        int num2 = 23;
        System.out.println(Add(num1, num2));
    }
}
