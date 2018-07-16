package come.class33_DP4.attempt02;

public class Q2_2_LongestAscendingSubsequence {
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] dp = new int[array.length];
        int result = 1;
        dp[0] = 1;
        for (int i = 1; i < array.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
