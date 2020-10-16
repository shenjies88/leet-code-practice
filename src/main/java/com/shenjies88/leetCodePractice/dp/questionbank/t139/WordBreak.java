package com.shenjies88.leetCodePractice.dp.questionbank.t139;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author shenjies88
 * @since 2020/9/24-3:31 PM
 */
public class WordBreak {
    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("abcd", Arrays.asList("a", "abc", "b", "cd")));//true
        System.out.println(new WordBreak().wordBreak("a", Arrays.asList("a")));//true
        System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "code")));//true
        System.out.println(new WordBreak().wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));//true
        System.out.println(new WordBreak().wordBreak("applepenapple", Arrays.asList("apple", "pen")));//true
        System.out.println(new WordBreak().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));//false
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        /*
            dp[i] 长度为0到i串 是否可以拆解 0 <= i < s.length
        * */
        Map<String, String> wordMap = wordDict.stream().collect(Collectors.toMap(i -> i, i -> i));
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                int originJ = j - 1;
                boolean isWord = isWord(s, i, j, wordMap);
                if (i == 0 && isWord) {
                    dp[originJ] = true;
                    if (originJ == s.length() - 1) {
                        return true;
                    }
                    continue;
                }
                if (i != 0 && isWord && dp[i - 1]) {
                    if (originJ == s.length() - 1) {
                        return true;
                    }
                    dp[originJ] = true;
                }
            }
        }
        return false;
    }

    private boolean isWord(String s, int start, int end, Map<String, String> wordDict) {
        String s1 = s.substring(start, end);
        return wordDict.get(s1) != null;
    }
}
