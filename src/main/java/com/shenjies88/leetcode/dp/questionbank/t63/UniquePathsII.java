package com.shenjies88.leetcode.dp.questionbank.t63;

/**
 * @author shenjies88
 * @since 2020/09/22/17:22
 */
public class UniquePathsII {
    public static void main(String[] args) {
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //dp[i][j] 第i行第j列的走法
        //临界条件 dp[0][0]
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (i == j && i == 0) {
                    continue;
                }
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
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
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[obstacleGrid.length - 1].length - 1];
    }
}
