package come.eClass8_DP;

public class Q6_LongestCommonSubsequence {
    public int longest(String source, String target) {
        int[][] dp = new int[source.length() + 1][target.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (source.charAt(i - 1) == target.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[source.length()][target.length()];
    }
}
