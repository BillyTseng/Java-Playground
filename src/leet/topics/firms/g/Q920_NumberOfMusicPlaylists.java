package leet.topics.firms.g;

public class Q920_NumberOfMusicPlaylists {
    public int numMusicPlaylists(int N, int L, int K) {
        final int MOD = 1_000_000_007;

        long[][] dp = new long[L + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= N; j++) {
                // case 1: add a new song to the list.
                dp[i][j] += dp[i - 1][j - 1] * (N - (j - 1));
                // case 2: add a old song to the list.
                // Using Math.max to deal with possible neg value.
                dp[i][j] += dp[i - 1][j] * Math.max(0, j - K);
                dp[i][j] %= MOD;
            }
        }
        return (int)dp[L][N];
    }
}
