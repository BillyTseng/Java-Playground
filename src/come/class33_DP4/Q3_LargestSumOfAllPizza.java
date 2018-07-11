package come.class33_DP4;

public class Q3_LargestSumOfAllPizza {
    public int largestSum(int[] input) {
        int n = input.length;
        int[][] dp = new int[n][n];

        // Base case, 1 piece of pizza
        for (int i = 0; i < n; i++) {
            dp[i][i] = i;
        }

        // Base case, 2 piece of pizza
        for (int i = 0; i + 1 < n; i++) {
            dp[i][i + 1] = Math.max(input[i], input[i + 1]);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                // pick left pizza
                int leftCase = 0;
                if (input[i + 1] > input[j]) {
                    leftCase = input[i] + dp[i + 2][j];
                } else {
                    leftCase = input[i] + dp[i + 1][j - 1];
                }

                // pick right pizza
                int rightCase = 0;
                if (input[i] > input[j - 1]) {
                    rightCase = input[j] + dp[i - 1][j - 1];
                } else {
                    rightCase = input[j] + dp[i][j - 2];
                }
                dp[i][j] = Math.max(leftCase, rightCase);
            }
        }
        return dp[0][n - 1];
    }
}
