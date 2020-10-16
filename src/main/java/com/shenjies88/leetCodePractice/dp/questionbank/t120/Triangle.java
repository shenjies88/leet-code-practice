package com.shenjies88.leetCodePractice.dp.questionbank.t120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shenjies88
 * @since 2020/9/24-9:33 AM
 */
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3, 4));
        input.add(Arrays.asList(6, 5, 7));
        input.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new Triangle().minimumTotal(input));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int lastRow = triangle.size() - 1;
        int[][] dp = new int[triangle.size()][triangle.get(lastRow).size()];
        for (int i = 0; i < triangle.get(lastRow).size(); i++) {
            dp[lastRow][i] = triangle.get(lastRow).get(i);
        }
        for (int i = lastRow - 1; i >= 0; i--) {
            List<Integer> currList = triangle.get(i);
            for (int j = 0; j < currList.size(); j++) {
                dp[i][j] = Math.min(currList.get(j) + dp[i + 1][j], currList.get(j) + dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}
