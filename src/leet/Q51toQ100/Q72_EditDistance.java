package leet.Q51toQ100;

public class Q72_EditDistance {
    // example, horse v.s. ros
    //  0 1 2 3 4 5
    //    h o r s e
    //  0 1 2 3 4 5
    //r 1 1 2 2 3 4
    //o 2 2 1 2 3 4
    //s 3 3 2 2 2 3

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    }
                }
            }
        }
        return dp[m][n];
    }
}
