package com.shenjies88.leetCodePractice.dp.questionbank.t746;

/**
 * @author shenjies88
 * @since 2020/09/17/18:04
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));//6
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{0, 1, 1, 0}));//1
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
