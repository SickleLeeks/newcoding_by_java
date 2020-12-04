package com.jz.day1106;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 字符流中第一个不重复的字符
 */
public class FirstAppearingOnce_JZ {
//    // 方法1
//    private int index = 0;// index用于记录某个字符出现的位置
//    private int[] arr = new int[128];
//
//    // 初始化数组，赋值为-1
//    public FirstAppearingOnce_JZ() {
//        for (int i = 0; i < 128; i++) {
//            arr[i] = -1;
//        }
//    }
//
//    public void Insert1(char ch) {
//        // arr[ch]和arr[(int)ch]是一样的
//        if (arr[ch] == -1) {
//            arr[ch] = index;// 第一次出现时，记录其在字符流种的位置
//        } else if (arr[ch] >= 0) { //大于0，说明某个字符出现过了
//            arr[ch] = -2; //多次出现时，重置
//        }
//        index++;
//    }
//
//    public char FirstAppearingOnce1() {
//        int minIndex = Integer.MAX_VALUE;// 方便比较出最靠前的那个出现1次的字符
//        char ch = '#';
//        for (int i = 0; i < 128; i++) {
//            if (arr[i] >= 0 && arr[i] <= minIndex) {
//                // 字符赋值给ch，位置赋值给minIndex
//                ch = (char) i;
//                minIndex = arr[i];
//            }
//        }
//        return ch;
//    }

    // 方法2
    int[] count = new int[128]; // 字符出现的次数
    int[] index = new int[128]; // 字符出现的位置
    int number = 0;// 用于标记字符流的位置

    public void Insert2(char ch) {
        count[ch]++;
        index[ch] = number++;
    }

    public char FirstAppearingOnce2() {
        int minIndex = number;
        char ch = '#';
        for (int i = 0; i < 128; i++) {
            if (count[i] == 1 && index[i] < minIndex) {
                ch = (char) i;
                minIndex = index[i];
            }
        }
        return ch;
    }

    // 方法3
    Map<Character, Integer> map = new LinkedHashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char chr : map.keySet()) {
            if (map.get(chr) == 1) {
                return chr;
            }
        }
        return '#';
    }
}
