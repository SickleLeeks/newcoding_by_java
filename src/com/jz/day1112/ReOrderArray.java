package com.jz.day1112;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class ReOrderArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(",");
        int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        int[] res = reOrderArray(nums);
        System.out.println(Arrays.toString(res));
    }

    public static int[] reOrderArray(int[] array) {
        // write code here
        if (array == null || array.length <= 1) {
            return array;
        }
        int i = 0; // 奇数
        while (i < array.length - 1) {
            int j = i + 1;
            // 如果i指针的数字是偶数，则
            if (array[i] % 2 == 0) {
                // 如果i指针的数字是偶数，则
                boolean flag = true;
                while (j < array.length && flag) {
                    if (array[j] % 2 != 0) {
                        flag = false;
                    } else {
                        j++;
                    }
                }
                if (flag) {
                    break;
                }
                int tmp = array[j];
                for (int k = j - 1; k >= i; k--) {
                    array[k + 1] = array[k];
                }
                array[i] = tmp;
            }
            i++;
        }
        return array;
    }
}
