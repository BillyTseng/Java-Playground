package come.Freq;

/**
 * 516. Longest Palindromic Subsequence - medium
 */
public class Q8_LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int mIAddOneJminusOne = 0;
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                int mIJ = 0;
                if (s.charAt(i) == s.charAt(j)) {
                    mIJ = 2 + mIAddOneJminusOne;
                } else {
                    mIJ = Math.max(dp[j], dp[j - 1]);
                }
                mIAddOneJminusOne = dp[j];
                // this dp[j] is the next loop's dp[j - 1]
                dp[j] = mIJ;
            }
        }
        return dp[n - 1];
    }
}
