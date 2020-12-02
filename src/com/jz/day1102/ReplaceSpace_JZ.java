package com.jz.day1102;

public class ReplaceSpace_JZ {
    /**
     * 替换空格
     *
     * @param str
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return "";
        }
        String res = str.toString();
        return res.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("We are Happy");
        System.out.println(replaceSpace(str));
    }
}
