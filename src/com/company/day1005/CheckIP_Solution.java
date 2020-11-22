package com.company.day1005;

public class CheckIP_Solution {
    /**
     * 验证IP地址
     *
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public static String solve(String IP) {
        String res = "Neither";
        if ("".equals(IP)) {
            return res;
        }
        if (IP.contains(".")) {
            return checkIPv4(IP);
        } else if (IP.contains(":")) {
            return checkIPv6(IP);
        } else {
            return res;
        }
    }

    private static String checkIPv6(String ip) {
        String[] part = ip.split("\\:");
        if (part.length != 8) {
            return "Neither";
        }
        for (int i = 0; i < part.length; i++) {
            if (part[i].length() > 4) {
                return "Neither";
            }
            int count = 0;
            for (int j = 0; j < part[i].length(); j++) {
                if ((part[i].charAt(j) >= '0' && part[i].charAt(j) <= '9') ||
                        (part[i].charAt(j) >= 'A' && part[i].charAt(j) <= 'Z') ||
                        (part[i].charAt(j) >= 'a' && part[i].charAt(j) <= 'z')) {
                    if (part[i].charAt(j) == '0') {
                        count++;
                    }
                    continue;
                } else {
                    return "Neither";
                }
            }
            if (part[i].length() > 1 && count == part[i].length()) {
                return "Neither";
            }
        }
        return "IPv6";
    }

    private static String checkIPv4(String ip) {
        String[] part = ip.split("\\.");
        if (part.length != 4) {
            return "Neither";
        }
        for (int i = 0; i < part.length; i++) {
            if (part[i].length() > 3) {
                return "Neither";
            }
            for (int j = 0; j < part[i].length(); j++) {
                if (part[i].length() > 1 && part[i].charAt(0) == '0') {
                    return "Neither";
                } else if (part[i].charAt(j) >= '0' && part[i].charAt(j) <= '9') {
                    continue;
                } else {
                    return "Neither";
                }
            }
            int num = Integer.parseInt(part[i]);
            if (num < 0 || num > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public static void main(String[] args) {
        String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        System.out.println(solve(ip));
    }
}
