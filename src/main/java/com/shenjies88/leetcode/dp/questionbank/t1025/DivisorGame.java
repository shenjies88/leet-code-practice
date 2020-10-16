package com.shenjies88.leetcode.dp.questionbank.t1025;

/**
 * @author shenjies88
 * @since 2020/9/17-9:25 PM
 */
public class DivisorGame {
    public static void main(String[] args) {
//        System.out.println(new DivisorGame().divisorGame(3));
//        System.out.println(new DivisorGame().divisorGame(4));
//        System.out.println(new DivisorGame().divisorGame(5));
        System.out.println(new DivisorGame().divisorGame(10));
    }

    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        dp[1] = false;
        for (int i = 2; i <= N; i++) {
            boolean flag = true;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    flag = !dp[i - j];
                    if (flag) {
                        break;
                    }
                }
            }
            dp[i] = flag;
        }
        return dp[N];
    }
}
