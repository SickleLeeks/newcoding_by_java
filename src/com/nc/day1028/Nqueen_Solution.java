package com.nc.day1028;

/**
 * N皇后问题
 */
public class Nqueen_Solution {
    /**
     * @param n int整型 the n
     * @return int整型
     */
    private static int res;

    public static int Nqueen(int n) {
        res = 0;
        solveByDFS(new int[n], 0);
        return res;
    }

    /**
     * @param nums  :每一行放在哪个位置，nums[0]=4，表示第0行的皇后放在第4列
     * @param curr： 当前已经放了几行
     */
    private static void solveByDFS(int[] nums, int curr) {
        int n = nums.length;
        // curr == n 表示每一行都已经放了皇后，说明找到了一种方案
        if (curr == n) {
            res++;
            return;
        }
        // 找到可访问的位置
        boolean[] visited = new boolean[n];
        // 遍历之前的每一行（均已放置皇后）,把当前行中所有会和之前的皇后冲突的位置都排除掉
        // i表示判断到第几行，在第i行的皇后在（i,nums[i]）上
        for (int i = 0; i < curr; i++) {
            // e表示第i行到当前行的距离，要根据这个距离来判断斜向冲突的位置
            int e = curr - i;
            // v表示第i行的皇后放在哪一列，这一列需要被排除掉（visited[v] = true）
            int v = nums[i];
            // right表示右下方发生冲突的列，left表示左下方发生冲突的列
            // nums[0] = 3，curr=2说明第0行的皇后放在（0，3）
            // 那么在当前行也就是第2行，（2，1）和（2，5）就与（0，3）在同一斜向
            // 即right = v+e = nums[0] + (curr-i) = 3+（2-0） = 5
            // left = v-e = nums[0]-(curr-i) = 3-(2-0) = 1
            int right = v + e;
            int left = v - e;
            visited[v] = true;
            if (left >= 0) {
                visited[left] = true;
            }
            if (right < n) {
                visited[right] = true;
            }
        }
        // 对当前行剩余所有可能放皇后的位置进行递归
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                nums[curr] = i;
                solveByDFS(nums, curr + 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(Nqueen(n));
    }
}
