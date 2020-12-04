package com.nc.day1015;

import com.util.Interval;

import java.util.*;

public class MergeRange_Solution {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() == 1 || intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, Comparator.comparingInt(o -> o.start));
        ArrayList<Interval> res = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= end) {
                end = Math.max(end, intervals.get(i).end);
            } else {
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(10, 30));
        intervals.add(new Interval(20, 60));
        intervals.add(new Interval(80, 100));
        intervals.add(new Interval(150, 180));

        ArrayList<Interval> res = merge(intervals);
        for (int i = 0; i < res.size(); i++) {
            System.out.println("[" + res.get(i).start + "," + res.get(i).end + "]");
        }
    }
}
