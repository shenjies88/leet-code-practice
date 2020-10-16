package com.shenjies88.leetCodePractice.dp.questionbank.t392;

/**
 * @author shenjies88
 * @since 2020/09/18/13:38
 */
public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("abc", "ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence("axc", "ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence("aaaaaa", "bbaaaa"));
        System.out.println(new IsSubsequence().isSubsequence("bb", "ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence("rjufvjafbxnbgriwgokdgqdqewn", "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq"));
    }

    public boolean isSubsequence(String s, String t) {
        if (t.length() == 0 && s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        if (s.length() == 1) {
            return t.contains(s);
        }
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        boolean[][] dp = new boolean[tCharArray.length][sCharArray.length];
        boolean slt = sCharArray.length == tCharArray.length;
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i < j) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = sCharArray[j] == tCharArray[i];
                    continue;
                }
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = (sCharArray[j] == tCharArray[i]);
                    continue;
                }
                dp[i][j] = dp[i - 1][j - 1] && (sCharArray[j] == tCharArray[i]);
                if (j == s.length() - 1 && dp[i][j]) {
                    return true;
                }
            }
        }
        return dp[tCharArray.length - 1][sCharArray.length - 1];
    }
}
