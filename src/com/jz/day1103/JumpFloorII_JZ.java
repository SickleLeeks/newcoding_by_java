package com.jz.day1103;

public class JumpFloorII_JZ {
    /**
     * 变态跳台阶
     * f(n) = f(n-1)+f(n-2)+...+f(1)
     * f(n-1) = f(n-2)+...+f(1)
     * f(n) = 2(f(n-2))
     *
     * @param target
     * @return
     */
    public static int JumpFloorII(int target) {
        return target <= 0 ? 0 : (int) Math.pow(2, target - 1);
    }

    public static void main(String[] args) {
        int target = 4;
        System.out.println(JumpFloorII(target));
    }
}
