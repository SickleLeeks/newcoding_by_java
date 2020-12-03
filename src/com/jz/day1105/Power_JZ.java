package com.jz.day1105;

public class Power_JZ {
    /**
     * 数值的整数次方
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public static void main(String[] args) {
        int base = 2;
        int exponent = 3;
        System.out.println(Power(base, exponent));
    }
}
