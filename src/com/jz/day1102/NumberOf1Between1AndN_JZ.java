package com.jz.day1102;

public class NumberOf1Between1AndN_JZ {
    /**
     * 整数中1出现的次数
     *
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;
        while (n != 0) {
            String str = String.valueOf(n);
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1') {
                    res++;
                }
            }
            n--;
        }
        return res;
    }

    // 计算高低位
    public static int NumberOf1Between1AndN_Solution1(int n) {
        int count = 0;
        int i = 1;
        int current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            before = n / (i * 10);//高位
            current = (n / i) % 10;// 当前位
            after = n - (n / i) * i;//低位
            if (current == 0) {
                // 如果为0，则出现1的次数由高位决定，等于高位数组*当前位数
                count = count + before * i;
            } else if (current == 1) {
                //如果为1，出现1的次数由高位和低位决定，高位*当前位+低位+1
                count = count + before * i + after + 1;
            } else if (current > 1) {
                //如果大于1，则出现1的次数由高位决定，（高位数字+1）*当前位数
                count = count + (before + 1) * i;
            }
            //前移一位
            i = i * 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 1001;
        System.out.println(NumberOf1Between1AndN_Solution(n));
    }
}
