package com.shenjies88.leetcode.dp.questionbank.t474;

/**
 * @author shenjies88
 * @since 2020/09/18/9:09
 */
public class OnesZeroes {
    public static void main(String[] args) {
        System.out.println(new OnesZeroes().findMaxForm(new String[]{"10", "0", "1"}, 1, 1));//2
        System.out.println(new OnesZeroes().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));//4
        System.out.println(new OnesZeroes().findMaxForm(new String[]{"11111", "100", "1101", "1101", "11000"}, 5, 7));//3
    }

    public int findMaxForm(String[] strs, int m, int n) {
        //类似背包问题，每个字符串可选可不选，价值都是1
        //他们的重量由 m+n组成
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int k = 0; k < strs.length; k++) {
            for (int m1 = m; m1 >= 0; m1--) {
                for (int n1 = n; n1 >= 0; n1--) {
                    int[] oz = findOneZero(strs[k]);
                    if (m1 - oz[0] >= 0 && n1 - oz[1] >= 0) {
                        dp[m1][n1] = Math.max(dp[m1][n1], dp[m1 - oz[0]][n1 - oz[1]] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public int[] findOneZero(String input) {
        int[] result = new int[2];
        int oneCount = 0;
        int zeroCount = 0;
        for (char c : input.toCharArray()) {
            switch (c) {
                case '0':
                    zeroCount++;
                    break;
                case '1':
                    oneCount++;
                    break;
            }
        }
        result[0] = zeroCount;
        result[1] = oneCount;
        return result;
    }
}
