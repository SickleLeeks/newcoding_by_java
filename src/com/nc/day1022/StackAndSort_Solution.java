package com.nc.day1022;

import java.util.*;

/**
 * 栈和排序
 *
 * @author epngxnz
 */
public class StackAndSort_Solution {

    /**
     * 栈排序
     *
     * @param a int整型一维数组 描述入栈顺序
     * @return int整型一维数组
     */
    // 运行超时
    public static int[] solve(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int index = 0, n = a.length;
        int Max = Integer.MIN_VALUE;
        int[][] maxarr = new int[n][2];
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] > Max) {
                Max = a[i];
                index = i;
            }
            maxarr[i][0] = Max;
            maxarr[i][1] = index;
        }
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            stack.push(a[i]);
            if (maxarr[i][1] == i) {
                list.add(stack.pop());
                while (!stack.isEmpty() && i < n - 1 && stack.peek() > maxarr[i + 1][0]) {
                    list.add(stack.pop());
                }
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        int[] res = new int[a.length];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{2, 1, 5, 3, 4};
        ArrayList<int[]> arrayList = getRandomNum(10, 20);
        for (int[] arr : arrayList) {
            System.out.println("============================");
            System.out.println(Arrays.toString(arr));
            System.out.println("                             ");
            System.out.println(Arrays.toString(solve(arr)));
            System.out.println(Arrays.toString(solve2(arr)));
//            System.out.println(Arrays.toString(solve3(arr)));
            System.out.println("============================");
        }
    }

    private static ArrayList<int[]> getRandomNum(int size, int len) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int[] arr = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = (int) (Math.random() * 1000000) + 1;
            }
            arrayList.add(arr);
        }
        return arrayList;
    }

    public static int[] solve2(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        return help(a, a.length);
    }

    private static int[] help(int[] a, int length) {
        int[] Max = new int[length];
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = length - 1; i >= 0; i--) {
            if (a[i] > max) {
                max = a[i];
                index = i;
            }
            Max[i] = max;
        }
        Stack<Integer> stk = new Stack<>();
        Queue<Integer> ans = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            stk.push(a[i]);
            if (Max[i] == a[i]) {
                ans.offer(stk.peek());
                stk.pop();
                while (i + 1 < length && !stk.isEmpty() && stk.peek() > Max[i + 1]) {
                    ans.offer(stk.peek());
                    stk.pop();
                }
            }
        }
        while (!stk.isEmpty()) {
            ans.offer(stk.peek());
            stk.pop();
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] solve3(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        return help2(a, a.length);
    }

    private static int[] help2(int[] a, int length) {
        boolean[] bq = new boolean[length + 1];
        Deque<Integer> res = new ArrayDeque<>();
        Stack<Integer> stk = new Stack<>();
        int top = 0;
        for (int i = length; i >= 1; i--) {
            if (bq[i] == false) {
                while (a[top] != i) {
                    stk.push(a[top]);
                    bq[a[top]] = true;
                    top++;
                }
                res.addLast(a[top]);
                top++;
                bq[i] = true;
            } else {
                if (stk.peek() == i) {
                    stk.pop();
                    res.addLast(i);
                    bq[i] = false;
                }
            }
        }
        while (!stk.isEmpty()) {
            res.addLast(stk.pop());
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
