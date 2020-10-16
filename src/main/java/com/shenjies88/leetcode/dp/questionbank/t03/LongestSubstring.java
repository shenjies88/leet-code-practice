package com.shenjies88.leetcode.dp.questionbank.t03;

/**
 * @author shenjies88
 * @since 2020/6/10-5:42 PM
 */
public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring("aab"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcdefgaabcedftdalkdsabcdefghijklmn"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabcdb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int sum = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j);
                String next = s.substring(j, j + 1);
                if (!sub.contains(next)) {
                    sum = Math.max(sum, sub.length() + 1);
                } else {
                    break;
                }
            }
        }
        return sum;
    }
}
