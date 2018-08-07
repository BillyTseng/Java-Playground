package come.eClass8_DP;

public class Q5_BurstBallons {
    public int maxCoins(int[] nums) {
        int[] input = new int[nums.length + 2];
        int n = input.length;
        input[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            input[i + 1] = nums[i];
        }
        input[n - 1] = 1;

        int[][] dp = new int[n][n];

        for (int range = 2; range < n; range++) {
            for (int l = 0; l < n - range; l++) {
                int r = l + range;
                for (int m = l + 1; m < r; m++) {
                    dp[l][r] = Math.max(dp[l][r], input[l] * input[m] * input[r] + dp[l][m] + dp[m][r]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
