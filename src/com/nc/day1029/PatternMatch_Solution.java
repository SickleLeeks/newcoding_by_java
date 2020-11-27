package com.nc.day1029;

/**
 * 正则表达式匹配
 */
public class PatternMatch_Solution {
    public static boolean match(char[] str, char[] pattern) {
        if (str == null && pattern == null) {
            return true;
        }
        if (str == null || pattern == null) {
            return false;
        }
        return matchString(str, 0, pattern, 0);
    }

    private static boolean matchString(char[] str, int i, char[] pattern, int j) {
        if (str.length == i && pattern.length == j) {
            // 匹配结束
            return true;
        } else if (str.length > i && pattern.length == j) {
            // 字符串不为空，模式匹配结束
            return false;
        }
        // 下一个字符是‘*’
        boolean next = (j + 1 < pattern.length && pattern[j + 1] == '*');
        if (next) {
            // j元素的字符为.或者与匹配串相同，则视为相同
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) {
                // 可以理解为'*'号让前一个字符为0，或者'*'号匹配到了这个字符，那因为'*'有任意次数，可以一直使用
                return matchString(str, i, pattern, j + 2) || matchString(str, i + 1, pattern, j);
            } else {
                // 将'*'前面的视为0，跳过
                return matchString(str, i, pattern, j + 2);
            }
        } else {
            // 如果没有*字符，则如果可以保证为.或者相同都可以继续，否则返回false
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) {
                return matchString(str, i + 1, pattern, j + 1);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        char[] str = new char[]{'a', 'a', 'a'};
        char[] pattern = new char[]{'a', '*', 'a'};

        System.out.println(match(str, pattern));
    }
}
