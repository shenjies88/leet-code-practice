package com.shenjies88.leetcode.dp.questionbank.t152;

/**
 * @author shenjies88
 * @since 2020/9/24-10:27 AM
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{-2, 0, -1}));
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{-2, 3, -4}));
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{-1, -2, -9, -6}));
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{2, -5, -2, -4, 3}));
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{0, 2}));
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{1, 0, -1, 2, 3, -5, -2}));
    }

    public int maxProduct(int[] nums) {
        /*
            dp[i][0] 长度为i最大的负数
            dp[i][1] 长度为i最大的正数
        * */
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxNegative = nums[i] * dp[i - 1][0];
            int maxPositive = nums[i] * dp[i - 1][1];
            if (maxNegative < 0 && maxPositive < 0) {
                dp[i][0] = Math.min(maxNegative, maxPositive);
                dp[i][1] = nums[i];
            } else if (maxNegative > 0 && maxPositive > 0) {
                dp[i][0] = nums[i];
                dp[i][1] = Math.max(maxNegative, maxPositive);
            } else if (maxNegative == 0 && maxPositive == 0) {
                dp[i][0] = nums[i];
                dp[i][1] = nums[i];
            } else {
                dp[i][0] = Math.min(maxNegative, maxPositive);
                dp[i][1] = Math.max(maxNegative, maxPositive);
            }
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }
}
