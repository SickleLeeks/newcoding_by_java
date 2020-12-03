package com.jz.day1104;

import org.w3c.dom.css.Rect;

public class RectCover_JZ {
    /**
     * 矩形覆盖
     *
     * @param target
     * @return
     */
    public static int RectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

    public static void main(String[] args) {
        int target = 4;
        System.out.println(RectCover(target));
    }
}
