package com.jz.day1108;

public class ReverseSentence_JZ {
    /*
    翻转单词顺序列
     */
    public static String ReverseSentence(String str) {
        if ("".equals(str) || str.length() == 0 || "".equals(str.trim())) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = str.split("");
        for (int i = strings.length - 1; i > 0; i--) {
            stringBuilder.append(strings[i]).append("");
        }
        stringBuilder.append(strings[0]);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "   ";
        System.out.println(ReverseSentence(str));
    }
}
