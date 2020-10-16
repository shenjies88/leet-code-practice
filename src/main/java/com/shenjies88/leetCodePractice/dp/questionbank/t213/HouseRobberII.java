package com.shenjies88.leetCodePractice.dp.questionbank.t213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shenjies88
 * @since 2020/09/14/18:03
 */
public class HouseRobberII {
    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[]{2, 1, 1, 2}));//3
        System.out.println(new HouseRobberII().rob(new int[]{1, 3, 1, 3, 100}));//103
        System.out.println(new HouseRobberII().rob(new int[]{2, 3, 2}));//3
        System.out.println(new HouseRobberII().rob(new int[]{2, 7, 9, 3, 1}));//11
        System.out.println(new HouseRobberII().rob(new int[]{4, 1, 2, 7, 5, 3, 1}));//14
        System.out.println(new HouseRobberII().rob(new int[]{1, 7, 9, 4}));//11
        System.out.println(new HouseRobberII().rob(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));//16
    }

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
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        int[][] dp = new int[nums.length][2];
        List<Integer> resultList = new ArrayList<>(3);
        resultList.add(maxTotal(nums, 0, dp));
        resultList.add(maxTotal(nums, 1, dp));
        resultList.add(maxTotal(nums, 2, dp));
        return resultList.stream().max(Integer::compareTo).get();
    }

    int maxTotal(int[] nums, int index, int[][] dp) {
        Arrays.stream(dp).forEach(e -> Arrays.fill(e, 0));
        int max = Integer.MIN_VALUE;
        int indexLeft = index - 1 < 0 ? nums.length - 1 : index - 1;
        int indexRight = (index + 1) % nums.length;
        dp[index][0] = 0;
        dp[index][1] = nums[index];
        dp[indexLeft][0] = nums[index];
        dp[indexLeft][1] = 0;
        dp[indexRight][0] = nums[index];
        dp[indexRight][1] = 0;
        //从index + 2开始遍历 ，遍历至 index - 1
        int left1 = index - 1 < 0 ? nums.length - 1 : index - 1;
        for (int j = (index + 2) % nums.length; j != left1; ) {
            int left = j - 1 < 0 ? nums.length - 1 : j - 1;
            dp[j][0] = Math.max(dp[left][0], dp[left][1]);
            dp[j][1] = dp[left][0] + nums[j];
            max = Math.max(max, Math.max(dp[j][0], dp[j][1]));
            j = (j + 1) % nums.length;
        }
        return max;
    }
}
