package com.shenjies88.leetcode.dp.questionbank.t198;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shenjies88
 * @since 2020/09/17/18:15
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(nums[0] + nums[2], nums[1]);
        }
        int[][] dp = new int[nums.length][2];
        List<Integer> resultList = new ArrayList<>(2);
        resultList.add(maxTotal(nums, 0, dp));
        resultList.add(maxTotal(nums, 1, dp));
        return resultList.stream().max(Integer::compareTo).get();
    }

    int maxTotal(int[] nums, int index, int[][] dp) {
        Arrays.stream(dp).forEach(e -> Arrays.fill(e, 0));
        int max = Integer.MIN_VALUE;
        int indexLeft = index - 1 < 0 ? Integer.MIN_VALUE : index - 1;
        int indexRight = index + 1 == nums.length ? Integer.MAX_VALUE : index + 1;
        dp[index][0] = 0;
        dp[index][1] = nums[index];
        if (indexLeft != Integer.MIN_VALUE) {
            dp[indexLeft][0] = nums[index];
            dp[indexLeft][1] = 0;
        }
        if (indexRight != Integer.MAX_VALUE) {
            dp[indexRight][0] = nums[index];
            dp[indexRight][1] = 0;
        }
        for (int j = index + 2; j < nums.length; j++) {
            int left = j - 1;
            dp[j][0] = Math.max(dp[left][0], dp[left][1]);
            dp[j][1] = dp[left][0] + nums[j];
            max = Math.max(max, Math.max(dp[j][0], dp[j][1]));
        }
        return max;
    }
}
