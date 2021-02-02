package com.jz.day1111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CD91 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(String.valueOf(br.readLine()));
        int[] arr = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        int res = solution(n, arr); //暴力递归法
        int res2 = solution2(n, arr); //动态规划法
        System.out.println(res);
        System.out.println(res2);
    }

    /**
     * 先手：former(i,j) = max(arr[i]+letter(i+1,j),arr[i]+letter(i,j-1))
     * 后手：letter(i,j) = min(former(i+1,j),former(i,j-1))
     * @param n
     * @param arr
     * @return
     */
    private static int solution2(int n, int[] arr) {
        if (arr == null || n == 0) {
            return 0;
        }
        // former[i][j]:表示玩家从arr[i...j]中先拿牌得到的分数
        int[][] former = new int[n][n];
        // letter[i][j]:表示玩家从arr[i...j]中后拿牌得到的分数
        int[][] letter = new int[n][n];
        for (int i = 0; i < n; i++) {
            former[i][i] = arr[i];
            letter[i][i] = 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j <= n - 1; j++) {
                former[i][j] = Math.max(arr[i] + letter[i + 1][j], arr[j] + letter[i][j - 1]);
                letter[i][j] = Math.min(former[i + 1][j], former[i][j - 1]);
            }
        }
        return Math.max(former[0][n - 1], letter[0][n - 1]);
    }

    // 暴力递归法
    private static int solution(int n, int[] arr) {
        if (arr == null || n == 0) {
            return 0;
        }
        // 分两种情况：先拿和后拿，即A和B
        return Math.max(former(0, n - 1, arr), latter(0, n - 1, arr));
    }

    // 表示arr[i...j]数组上的纸牌被绝顶聪明的人先拿
    private static int former(int i, int j, int[] arr) {
        if (i == j) {
            return arr[i];
        } else {
            return Math.max(arr[i] + latter(i + 1, j, arr), arr[j] + latter(i, j - 1, arr));
        }
    }

    // 表示arr[i...j]数组上的纸牌被绝顶聪明的人后拿
    private static int latter(int i, int j, int[] arr) {
        if (i == j) {
            return 0;
        } else {
            return Math.min(former(i + 1, j, arr), former(i, j - 1, arr));
        }
    }
}
