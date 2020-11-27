package com.nc.day1022;

import java.util.Arrays;

/**
 * 快速排序
 */
public class MySort_Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 将给定数组排序
     *
     * @param arr int整型一维数组 待排序的数组
     * @return int整型一维数组
     */
    public static int[] MySort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int left = 0;
        int right = arr.length - 1;
        quickSort(arr, left, right);
        return arr;
    }

    /**
     * 挖坑法
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // 哨兵位置
        int low = left;
        int high = right;
        int base = arr[left];
        while (low < high) {
            // 首先从右向左遍历，直到遇见小于哨兵的位置
            while (low < high && arr[high] >= base) {
                high--;
            }
            // 将大于哨兵的位置值赋给哨兵位置
            arr[low] = arr[high];
            // 然后从左向右遍历，直到遇见大于哨兵的位置
            while (low < high && arr[low] <= base) {
                low++;
            }
            // 将大于哨兵的位置值赋给高位
            arr[high] = arr[low];
        }
        // 第一轮结束后，将哨兵放在low==high的位置，也就是它最终的位置
        arr[low] = base;
        quickSort(arr, left, low - 1);
        quickSort(arr, low + 1, right);
    }

    /**
     * 左右指针法
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort2(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int low = left;
        int high = right;
        int base = arr[left];
        while (low < high) {
            // 从右向左遍历，直到遇到小于基准值的位置
            while (low < high && arr[high] >= base) {
                high--;
            }
            // 从左向右遍历，直到遇到大于基准值的位置
            while (low < high && arr[low] <= base) {
                low++;
            }
            // 交换两个位置，前者大于基准值，后者小于基准值
            if (left < high) {
                swap(arr, low, high);
            }
        }
        // 交换基准值和当前low==high的位置元素
        swap(arr, left, low);
        quickSort2(arr, left, low - 1);
        quickSort2(arr, low + 1, right);
    }

    private static void swap(int[] arr, int low, int high) {
        int tmp = arr[high];
        arr[high] = arr[low];
        arr[low] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{884688278, 387052570, 77481420, 537616843, 659978110, 215386675, 604354651, 64838842, 830623614, 544526209, 292446044, 570872277, 946770900, 411203381, 445747969, 480363996, 31693639, 303753633, 261627544, 884642435, 978672815, 427529125, 111935818, 109686701, 714012242, 691252458, 230964510, 340316511, 917959651, 544069623, 193715454, 631219735, 219297819, 151485185, 986263711, 805374069, 915272981, 493886311, 970466103, 819959858, 733048764, 393354006, 631784130, 70309112, 513023688, 17092337, 698504118, 937296273, 54807658, 353487181, 82447697, 177571868, 830140516, 536343860, 453463919, 998857732, 280992325, 13701823, 728999048, 764532283, 693597252, 433183457, 157540946, 427514727, 768122842, 782703840, 965184299, 586696306, 256184773, 984427390, 695760794, 738644784, 784607555, 433518449, 440403918, 281397572, 546931356, 995773975, 738026287, 861262547, 119093579, 521612397, 306242389, 84356804, 42607214, 462370265, 294497342, 241316335, 158982405, 970050582, 740856884, 784337461, 885254231, 633020080, 641532230, 421701576, 298738196, 918973856, 472147510, 169670404};
        int[] rex = MySort(arr);
        System.out.println(Arrays.toString(rex));
    }
}
