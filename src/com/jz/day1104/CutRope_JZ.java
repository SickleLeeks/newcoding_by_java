package com.jz.day1104;

public class CutRope_JZ {
    /**
     * 剪绳子
     *
     * @param target
     * @return
     */
    // 方法1, 暴力递归， 时间复杂度为O(n!)，空间复杂度为O(n)，最多分n段，每段长度为1，递归深度为n
    public static int cutRope(int target) {
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        } else {
            return backTrack(target);
        }
    }

    private static int backTrack(int n) {
        // n<=4，表明不分割的时候，长度是最长的。
        if (n <= 4) {
            return n;
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res += Math.max(res, i * backTrack(n - i));
        }
        return res;
    }

    // 记忆化递归, 时间复杂度为O(n^2)，空间复杂度为O(n)
    static int[] mark = null;

    public static int cutRope2(int target) {
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        }
        // 创建一个数组,初始值为0
        mark = new int[target + 1];
        return backTrack2(target);
    }

    private static int backTrack2(int target) {
        if (target <= 4) {
            return target;
        }
        if (mark[target] != 0) {
            return mark[target];
        }
        int ret = 0;
        for (int i = 1; i < target; i++) {
            ret = Math.max(ret, i * backTrack2(target - i));
        }
        return mark[target] = ret;
    }

    // 动态规划, 时间复杂度为O(n^2)，空间复杂度为O(n)
    public static int cutRope3(int target) {
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        }
        int[] mark = new int[target + 1];
        for (int i = 1; i <= 4; i++) {
            mark[i] = i;
        }
        for (int i = 5; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                mark[i] = Math.max(mark[i], j * mark[i - j]);
            }
        }
        return mark[target];
    }

    // 方法四，数学分析
    public static int cutRope4(int target) {
        if (target <= 0) {
            return 0;
        } else if (target == 1 || target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        } else {
            int m = target % 3;
            switch (m) {
                case 0:
                    return (int) Math.pow(3, target / 3);
                case 1:
                    return (int) Math.pow(3, target / 3 - 1) * 4;
                case 2:
                    return (int) Math.pow(3, target / 3) * 2;
                default:
                    return 0;
            }
        }
    }

    public static void main(String[] args) {
        int target = 8;
        System.out.println(cutRope(target));
        System.out.println(cutRope2(target));
    }
}
