package com.shenjies88.leetCodePractice.dp.questionbank.t62;

/**
 * @author shenjies88
 * @since 2020/09/22/17:07
 */
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        //dp[i][j] 第i行第j列需要的步数
        //边界条件 dp[0][0] = 1
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && i == 0) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
