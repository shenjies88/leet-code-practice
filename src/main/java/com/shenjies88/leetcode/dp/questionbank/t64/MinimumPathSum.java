package com.shenjies88.leetcode.dp.questionbank.t64;

/**
 * @author shenjies88
 * @since 2020/09/22/17:37
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{
                {1, 2, 5},
                {1, 2, 1}}));
    }

    public int minPathSum(int[][] grid) {
        //逆推法
        //从终点到起点，dp[0][0]即最终答案
        /*边界 dp[endRow][endCol] = grid[endRow][endCol]
         * */
        int[][] dp = new int[grid.length][grid[0].length];
        int endRow = grid.length - 1;
        int endCol = grid[endRow].length - 1;
        dp[endRow][endCol] = grid[endRow][endCol];
        for (int i = endRow; i >= 0; i--) {
            for (int j = endCol; j >= 0; j--) {
                if (i == endRow && j == endCol) {
                    continue;
                }
                if (i == endRow) {
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                    continue;
                }
                if (j == endCol) {
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                    continue;
                }
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}
