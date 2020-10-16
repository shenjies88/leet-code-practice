package com.shenjies88.leetCodePractice.dp.questionbank.t221;

/**
 * @author shenjies88
 * @since 2020/9/25-6:30 PM
 */
public class MaximalSquare {
    public static void main(String[] args) {
        System.err.println(new MaximalSquare().maximalSquare(new char[][]{
                {'0', '0', '1', '0'},
                {'1', '1', '1', '1'},//1,0
                {'1', '1', '1', '1'},//2,1
                {'1', '1', '1', '0'},
                {'1', '1', '0', '0'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '0'}
        }));
        System.err.println(new MaximalSquare().maximalSquare(new char[][]{
                {'1', '1', '1', '1', '1', '1', '1', '1'},//0,1
                {'1', '1', '1', '1', '1', '1', '1', '0'},//1,2
                {'1', '1', '1', '1', '1', '1', '1', '0'},//2,3
                {'1', '1', '1', '1', '1', '0', '0', '0'},//3,4
                {'0', '1', '1', '1', '1', '0', '0', '0'}}));
        System.err.println(new MaximalSquare().maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1'}

        }));
        System.err.println(new MaximalSquare().maximalSquare(new char[][]{
                {'1'}}));
        System.err.println(new MaximalSquare().maximalSquare(new char[][]{
                {'1', '0'},
                {'0', '0'}}));
    }

    public int maximalSquare(char[][] matrix) {
        /**
         * 状态
         *      dp[i][j]以i为横坐标j为纵坐标，为左上角定点的边长
         * 边界
         *      最后一行和最后一列边长都为0无法组成正方形
         */
        if (matrix.length == 0) {
            return 0;
        }
        int lastRow = matrix.length - 1;
        int lastCol = matrix[lastRow].length - 1;
        int[][] dp = new int[lastRow + 1][lastCol + 1];
        int maxSidelength = 0;
        for (int i = lastRow; i >= 0; i--) {
            for (int j = lastCol; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                if (i == lastRow || j == lastCol) {
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    maxSidelength = Math.max(maxSidelength, dp[i][j]);
                    continue;
                }
                //当前坐标点向下和右最大能扩展多少
                int loopIndex = Math.min(lastRow - i, lastCol - j);
                //最大只能扩展 比右下角多一个
                for (int x = 1; x <= loopIndex && x < dp[i + 1][j + 1] + 1; x++) {
                    //往右和往下一个相等并且都为1
                    //右下角为1
                    if (!(matrix[i + x][j] == matrix[i][j + x]
                            && matrix[i + x][j] == '1'
                            && matrix[i + 1][j + 1] == '1')) {
                        break;
                    }
                    dp[i][j] = x + 1;
                }
                dp[i][j] = Math.max(dp[i][j], 1);
                maxSidelength = Math.max(maxSidelength, dp[i][j]);
            }
        }
        return maxSidelength * maxSidelength;
    }
}
