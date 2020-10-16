package com.shenjies88.leetcode.dp.questionbank.t91;

/**
 * @author shenjies88
 * @since 2020/09/22/18:19
 */
public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("16205"));//2
        System.out.println(new DecodeWays().numDecodings("12120"));//3
        System.out.println(new DecodeWays().numDecodings("1212"));//5
        System.out.println(new DecodeWays().numDecodings("1010"));//1
        System.out.println(new DecodeWays().numDecodings("301"));//0
        System.out.println(new DecodeWays().numDecodings("1"));//1
        System.out.println(new DecodeWays().numDecodings("206"));//1
        System.out.println(new DecodeWays().numDecodings("226"));//3
        System.out.println(new DecodeWays().numDecodings("227"));//2
        System.out.println(new DecodeWays().numDecodings("0"));//0
        System.out.println(new DecodeWays().numDecodings("10"));//1
        System.out.println(new DecodeWays().numDecodings("27"));//1
        System.out.println(new DecodeWays().numDecodings("01"));//0
        System.out.println(new DecodeWays().numDecodings("0123"));//0
        System.out.println(new DecodeWays().numDecodings("100"));//0
        System.out.println(new DecodeWays().numDecodings("110"));//1
    }

    public int numDecodings(String s) {
        if (s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] dp = new int[s.length()];
        char[] c = s.toCharArray();
        dp[0] = 1;
        for (int i = 1; i < c.length; i++) {
            int currInt = c[i] - '0';
            int preInt = c[i - 1] - '0';
            int composeInt = 10 * preInt + currInt;
            boolean compose = composeInt <= 26 && composeInt > 0 && preInt != 0;
            int preDp = dp[i - 1];
            if (currInt != 0) {
                dp[i] = compose ? preDp + dp[Math.max(i - 2, 0)] : preDp;
            } else {
                if (!compose) {
                    return 0;
                }
                dp[i] = dp[Math.max(i - 2, 0)];
            }
        }
        return dp[c.length - 1];
    }
}
