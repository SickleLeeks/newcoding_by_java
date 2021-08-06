package com.jz.day1124;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 981 基于时间的键值存储
 * 没看懂题目
 */
public class TimeMap {
    class Pair implements Comparable<Pair> {
        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        public int hashCode() {
            return timestamp + value.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                Pair pair = (Pair) obj;
                return this.timestamp == pair.timestamp && this.value.equals(pair.value);
            }
            return false;
        }

        public int compareTo(Pair pair) {
            if (this.timestamp != pair.timestamp) {
                return this.timestamp - pair.timestamp;
            } else {
                return this.value.compareTo(pair.value);
            }
        }
    }

    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<>());
        pairs.add(new Pair(timestamp, value));
        map.put(key, pairs);
    }

    public String get(String key, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<>());
        //使用一个大于所有value的字符串，以确保在pairs中含有timestamp的情况下也返回大于timestamp的位置
        Pair pair = new Pair(timestamp, String.valueOf((char) 127));
        int i = binarySearch(pairs, pair);
        if (i > 0) {
            return pairs.get(i - 1).value;
        }
        return "";
    }

    private int binarySearch(List<Pair> pairs, Pair target) {
        int low = 0, high = pairs.size() - 1;
        if (high < 0 || pairs.get(high).compareTo(target) <= 0) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            Pair pair = pairs.get(mid);
            if (pair.compareTo(target) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */