package com.jz.day1129;

import java.util.*;

/**
 * 313. 超级丑数
 */
public class MthSuperUglyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            int[] primes = Arrays.stream(sc.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
            System.out.println(nthSuperUglyNumber(n, primes));
        }
        sc.close();
    }

    // 使用TreeSet
    public static int nthSuperUglyNumber(int n, int[] primes) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        for (int i = 1; i < n; i++) {
            Long min = set.pollFirst();
            for (int prime : primes) {
                set.add(min * prime);
            }
        }
        return Math.toIntExact(set.pollFirst());
    }

    // 优先队列（堆）
    public static int nthSuperUglyNumber2(int n, int[] primes) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        set.add(1L);
        while (n-- > 0) {
            long x = queue.poll();
            if (n == 0) return (int) x;
            for (int prime : primes) {
                if (!set.contains(prime * x)) {
                    set.add(prime * x);
                    queue.add(prime * x);
                }
            }
        }
        return -1;
    }
}
