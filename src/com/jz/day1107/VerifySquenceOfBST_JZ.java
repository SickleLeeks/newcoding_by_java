package com.jz.day1107;

public class VerifySquenceOfBST_JZ {
    /**
     * 二叉搜索树的后序遍历序列
     *
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence==null||sequence.length==0){
            return false;
        }
        return solve(sequence);
    }

    private static boolean solve(int[] sequence) {
        int n = sequence.length;
        int root = sequence[n-1];

    }

    public static void main(String[] args) {
        int[] sequence = new int[]{4, 8, 6, 12, 16, 14, 10};
        System.out.println(VerifySquenceOfBST(sequence));
    }
}
