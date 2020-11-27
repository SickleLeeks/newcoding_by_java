package com.nc.day1010;

/**
 * 寻找第K大
 */
public class FinkMaxK_Solution {
    public static int findKth(int[] a, int n, int K) {
        // write code here
        fastSort(a, 0, n - 1);
        // 第K大，即倒数第K个数，即第n-K个数
        return a[n - K];
    }

    /**
     * 快速排序
     * @param arr
     * @param low
     * @param high
     */
    private static void fastSort(int[] arr, int low, int high) {
        if (low < high) {
            // 寻找基准的正确索引rr
            int index = getIndex(arr, low, high);
            fastSort(arr, low, index - 1);
            fastSort(arr, index + 1, high);
        }
    }

    private static int getIndex(int[] arr, int low, int high) {
        int tmp = arr[low]; //基准数据
        while (low < high) {
            // 当队尾的元素大于等于基准数据时，向前挪动high的指针
            while (low < high && arr[high] >= tmp)
                high--;
            // 如果队尾元素小于基准数据，需要将其赋值给low位置
            arr[low] = arr[high];
            // 当队首元素小于等于基准数据时，向后挪动low的指针
            while (low < high && arr[low] <= tmp)
                low++;
            // 如果队首元素大于基准数据，需要将其赋值给high位置
            arr[high] = arr[low];
        }
        // 跳出循环时，low和high位置重合，此时low或high的位置就是tmp元素应该所在的位置
        arr[low] = tmp;
        return low;
    }


    public static void main(String[] args) {
        int[] num = new int[]{1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663};
        int n = 49;
        int K = 24;
        int res = findKth(num, n, K);
        System.out.println(res);
    }
}
