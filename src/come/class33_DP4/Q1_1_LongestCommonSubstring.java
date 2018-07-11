package come.class33_DP4;

import java.util.Arrays;

public class Q1_1_LongestCommonSubstring {
    public String longestCommon(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        int longest = 0, start = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > longest) {
                        longest = dp[i][j];
                        start = i - longest;
                    }
                }
            }
        }
        return new String(s.toCharArray(), start, longest);
    }

    public static void main(String[] args) {
        Q1_1_LongestCommonSubstring solution = new Q1_1_LongestCommonSubstring();
        System.out.println(solution.longestCommon("abccddefffghhh", "bdhghhf"));
    }
}
