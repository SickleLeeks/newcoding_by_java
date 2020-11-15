package com.company.day1026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RestoreIpAddresses_Solution {
    /**
     * @param s string字符串
     * @return string字符串ArrayList
     */
    static ArrayList<String> res;

    public static ArrayList<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return res;
        }
        int left = 1, right = s.length() - 1;
        while (left < right && left <= 3) {
            for (int i = left + 1; i < right; i++) {
                String A = s.substring(0, left);
                String B = s.substring(left, i);
                String C = s.substring(i, right);
                String D = s.substring(right);
                boolean flag = check(A, B, C, D);
                if (flag) {
                    String ip = A + "." + B + "." + C + "." + D;
                    if (!res.contains(ip)) {
                        res.add(ip);
                    }
                }
            }
            left++;
        }
        left = 1;
        while (left < right && right >= s.length() - 3) {
            for (int i = left + 1; i < right; i++) {
                String A = s.substring(0, left);
                String B = s.substring(left, i);
                String C = s.substring(i, right);
                String D = s.substring(right);
                boolean flag = check(A, B, C, D);
                if (flag) {
                    String ip = A + "." + B + "." + C + "." + D;
                    if (!res.contains(ip)) {
                        res.add(ip);
                    }
                }
            }
            right--;
        }
        right = s.length() - 1;
        while (left < right && left <= 3 && right >= s.length() - 3) {
            for (int i = left + 1; i < right; i++) {
                String A = s.substring(0, left);
                String B = s.substring(left, i);
                String C = s.substring(i, right);
                String D = s.substring(right);
                boolean flag = check(A, B, C, D);
                if (flag) {
                    String ip = A + "." + B + "." + C + "." + D;
                    if (!res.contains(ip)) {
                        res.add(ip);
                    }
                }
            }
            left++;
            right--;
        }
        Collections.sort(res);
        return res;
    }

    private static boolean check(String a, String b, String c, String d) {
        if (a.length() > 3 || Integer.parseInt(a) > 255 || (a.length() > 1 && a.charAt(0) == '0')) {
            return false;
        } else if (b.length() > 3 || Integer.parseInt(b) > 255 || (b.length() > 1 && b.charAt(0) == '0')) {
            return false;
        } else if (c.length() > 3 || Integer.parseInt(c) > 255 || (c.length() > 1 && c.charAt(0) == '0')) {
            return false;
        } else if (d.length() > 3 || Integer.parseInt(d) > 255 || (d.length() > 1 && d.charAt(0) == '0')) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        String ipstr = "172162541";
        System.out.println(restoreIpAddresses(ipstr));  // 通过率20%
        System.out.println(restoreIpAddresses2(ipstr)); // dfs回溯法
        System.out.println(restoreIpAddresses3(ipstr)); // 暴力
    }

    private static ArrayList<String> restoreIpAddresses3(String s) {
        ArrayList<String> list = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    if (len - k >= 4) {
                        continue;
                    }
                    int a, b, c, d;
                    a = Integer.parseInt(s.substring(0, i));
                    b = Integer.parseInt(s.substring(i, j));
                    c = Integer.parseInt(s.substring(j, k));
                    d = Integer.parseInt(s.substring(k));
                    if (a > 255 || b > 255 || c > 255 || d > 255) {
                        continue;
                    }
                    String ip = a + "." + b + "." + c + "." + d;
                    if (ip.length() < len + 3) {
                        continue;
                    }
                    list.add(ip);
                }
            }
        }
        return list;
    }

    private static ArrayList<String> restoreIpAddresses2(String s) {
        ArrayList<String> list = new ArrayList<>();
        if (s.length() == 0) {
            return list;
        }
        backTrack(s, 0, 3, list);
        return list;
    }

    /**
     * @param s：                字符串
     * @param i：                本次插入的起始位置
     * @param count：剩余可插入'.'的次数
     * @param list
     */
    private static void backTrack(String s, int i, int count, ArrayList<String> list) {
        if (count == 0) {
            String[] strings = s.split("\\.");
            if (strings.length < 4) {
                return;
            }
            for (String str : strings) {
                if (str.length() > 1 && str.charAt(0) == '0') {
                    return;
                }
                if (Integer.parseInt(str) < 0 || Integer.parseInt(str) > 255) {
                    return;
                }
            }
            list.add(s);
            return;
        }
        if (i >= s.length()) {
            return;
        }
        int n = s.length();
        // 插入到i字符后面
        backTrack(s.substring(0, i + 1) + "." + s.substring(i + 1, n), i + 2, count - 1, list);
        if (i + 2 < n) {
            backTrack(s.substring(0, i + 2) + "." + s.substring(i + 2, n), i + 3, count - 1, list);
        }
        if (i + 3 < n) {
            backTrack(s.substring(0, i + 3) + "." + s.substring(i + 3, n), i + 4, count - 1, list);
        }
    }
}
