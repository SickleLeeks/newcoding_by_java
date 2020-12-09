package com.jz.day1108;

import java.util.*;
import java.util.stream.Collectors;

public class PrintMinNumber_JZ {
    /**
     * 把数组排列成最小的数
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        // 需要将数组转换成列表
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        list.sort((Comparator<Object>) (o1, o2) -> {
            String num1 = String.valueOf(o1) + o2;
            String num2 = String.valueOf(o2) + o1;
            return Integer.parseInt(num1) - Integer.parseInt(num2);
        });
        System.out.println(list);
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] number = new int[]{3, 32, 321};
        System.out.println(PrintMinNumber(number));
    }
}
