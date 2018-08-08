package come.eClass8_DP;

public class Q10_RegularExpressionMatching {
    /**
     * dfs, same as https://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/
     */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        char c = p.charAt(0);
        if (p.length() > 1 && p.charAt(1) == '*') {
            int k = 0;

            do {
                if (isMatch(s.substring(k), p.substring(2))) {
                    return true;
                }
            } while (k < s.length() && match(s.charAt(k++), c));
            return false;
        }
        return !s.isEmpty() && match(s.charAt(0), c) && isMatch(s.substring(1), p.substring(1));
    }

    private boolean match(char c, char p) {
        return p == '.' || p == c;
    }

    // DP
    public boolean isMatchI(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length(); j >= 0; j--) {
                if (j == p.length()) {
                    dp[i][j] = i == s.length();
                } else {
                    char c = p.charAt(j);
                    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2] || (i != s.length() && match(s.charAt(i), c) && dp[i + 1][j]);
                    } else {
                        dp[i][j] = (i != s.length() && match(s.charAt(i), c) && dp[i + 1][j + 1]);
                    }
                }
            }
        }

        return dp[0][0];
    }
}
