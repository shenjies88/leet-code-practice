package com.shenjies88.leetCodePractice.dp.questionbank.t279;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shenjies88
 * @since 2020/09/27/13:43
 */
public class PerfectSquares {
    public static void main(String[] args) {
        System.err.println(new PerfectSquares().numSquares(14));
        System.err.println(new PerfectSquares().numSquares(4));
        System.err.println(new PerfectSquares().numSquares(12));
        System.err.println(new PerfectSquares().numSquares(13));
    }

    public int numSquares(int n) {
        /**
         * 状态
         *      dp[i] 组成i需要的平方数
         * 边界
         *      dp[1] = 1
         *      dp[2] = 2
         *      dp[3] = 3
         */
        switch (n) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
        }
        //构建平方数map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i * i <= n; i++) {
            Integer i1 = i * i;
            map.put(i1, i1);
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            if (map.get(i) != null) {
                dp[i] = 1;
                continue;
            }
            //从中间往两侧遍历
            int mid = i / 2;
            int remainder = i % 2;
            int minCount = Integer.MAX_VALUE;
            if (remainder == 0) {
                if (map.get(mid) != null) {
                    dp[i] = 2;
                    continue;
                }
                for (int j = 1; mid - j > 0; j++) {
                    minCount = Math.min(minCount, dp[mid - j] + dp[mid + j]);
                    if (minCount == 2) {
                        break;
                    }
                }
            } else {
                for (int j = 0; mid - j > 0; j++) {
                    minCount = Math.min(minCount, dp[mid - j] + dp[mid + j + 1]);
                    if (minCount == 2) {
                        break;
                    }
                }
            }
            dp[i] = minCount;
        }
        return dp[n];
    }
}
