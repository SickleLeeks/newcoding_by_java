package com.jz.day1127;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1337. 矩阵中战斗力最弱的 K 行
 */
public class KWeakestRows {
    // 自定义排序
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] row = mat[i];
            int s = 0;
            for (int v : row) {
                if (v == 1) s++;
            }
            pairs.add(new int[]{i, s});
        }
        Collections.sort(pairs, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pairs.get(i)[0];
        }
        return res;
    }
}
