package com.nc.day1011;

/**
 * 跳台阶
 */
public class JumpStage_Solution {
    public static int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(4));
    }
}
