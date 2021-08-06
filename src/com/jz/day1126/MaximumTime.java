package com.jz.day1126;

import java.util.Scanner;

/**
 * 1736. 替换隐藏数字得到的最晚时间
 */
public class MaximumTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String time = sc.nextLine();
            System.out.println(maximumTime(time));
        }
        sc.close();
    }

    public static String maximumTime(String time) {
        if (time.equals("") || time.length() == 0) {
            return "";
        }
        String hour = time.split(":")[0];
        String mine = time.split(":")[1];
        int first = hour.indexOf("?");
        int second = hour.lastIndexOf("?");
        if (first == second) {
            hour = getMaxHour(hour, first);
        } else {
            hour = "23";
        }
        first = mine.indexOf("?");
        second = mine.lastIndexOf("?");
        if (first == second) {
            mine = getMaxMins(mine, first);
        } else {
            mine = "59";
        }
        return hour + ":" + mine;
    }

    private static String getMaxMins(String mine, int index) {
        if (index == 0) {
            mine = mine.replace('?', '5');
        } else {
            mine = mine.replace('?', '9');
        }
        return mine;
    }

    private static String getMaxHour(String hour, int index) {
        if (index == 0) {
            if (hour.charAt(1) <= '3') {
                hour = hour.replace('?', '2');
            } else {
                hour = hour.replace('?', '1');
            }
        } else if (index == 1) {
            if (hour.charAt(0) == '0' || hour.charAt(0) == '1') {
                hour = hour.replace('?', '9');
            } else if (hour.charAt(0) == '2') {
                hour = hour.replace('?', '3');
            }
        }
        return hour;
    }

    // 贪心法
    public static String maximumTime2(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?') {
            arr[0] = ('4' <= arr[1] && arr[1] <= '9') ? '1' : '2';
        }
        if (arr[1] == '?') {
            arr[1] = (arr[0] == '2') ? '3' : '9';
        }
        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if (arr[4] == '?') {
            arr[4] = '9';
        }
        return new String(arr);
    }
}
