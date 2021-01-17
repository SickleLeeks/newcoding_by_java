package com.jz.day1109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  在行列都排好序的矩阵中找指定的数
 */
public class FindElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = br.readLine().split(" ");
        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);
        int K = Integer.parseInt(line1[2]);

        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        String isContain = find(N, M, K, matrix);
        System.out.println(isContain);
    }

    public static String find(int n, int m, int k, int[][] matrix) {
        if (n == 0 || m == 0 || k < matrix[0][0] || k > matrix[n - 1][m - 1]) {
            return "No";
        }
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (k > matrix[i][j]) {
                i++;
            } else if (k < matrix[i][j]) {
                j--;
            } else {
                return "Yes";
            }
        }
        return "No";
    }
}
