package com.shenjies88.leetcode.dp.questionbank.t264;

import java.util.PriorityQueue;

/**
 * @author shenjies88
 * @since 2020/09/27/16:45
 */
public class UglyNumberII {
    public static void main(String[] args) {
        System.err.println(new UglyNumberII().nthUglyNumber(10));
        System.err.println(new UglyNumberII().nthUglyNumber(453));
        System.err.println(new UglyNumberII().nthUglyNumber(82));
        System.err.println(new UglyNumberII().nthUglyNumber(16));
        System.err.println(new UglyNumberII().nthUglyNumber(11));
    }

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue();
        priorityQueue.add(1L);
        Long result = 0L;
        for (int i = 1; i <= n; i++) {
            result = priorityQueue.poll();
            if (!priorityQueue.contains(result * 2)) {
                priorityQueue.add(result * 2);
            }
            if (!priorityQueue.contains(result * 3)) {
                priorityQueue.add(result * 3);
            }
            if (!priorityQueue.contains(result * 5)) {
                priorityQueue.add(result * 5);
            }
        }
        return result.intValue();
    }
}