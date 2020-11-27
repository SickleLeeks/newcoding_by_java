package com.nc.day1005;

public class VersionCompare_Solution {
    /**
     * 比较版本号
     *
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public static int compare(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int size = Math.max(v1.length, v2.length);

        int i = 0;
        while (i < size) {
            int value1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int value2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (value1 < value2) {
                return -1;
            } else if (value1 > value2) {
                return 1;
            } else {
                i++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String v1 = "241.169.214.43.45";
        String v2 = "241.169.214.43.45.253";
        System.out.println(compare(v1, v2));
    }
}
