package com.shenjies88.leetCodePractice.dp.questionbank.t121;

/**
 * @author shenjies88
 * @since 2020/09/17/17:13
 */
public class BestTimeBuySellStock {
    public static void main(String[] args) {
        System.out.println(new BestTimeBuySellStock().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(prices[i], dp[i - 1]);
            max = Math.max(max, prices[i] - dp[i]);
        }
        return max;
    }
}
