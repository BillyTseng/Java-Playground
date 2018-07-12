package come.class26_BST_DP.attempt02;

public class Q4_1_CuttingWoodI {
    public int minCost(int[] cuts, int length) {
        int[] costs = new int[cuts.length + 2];
        costs[0] = 0;
        for (int i = 0; i < cuts.length; i++) {
            costs[i + 1] = cuts[i];
        }
        costs[costs.length - 1] = length;

        int[][] dp = new int[costs.length][costs.length];
        for (int row = dp.length - 2; row >= 0; row--) {
            for (int col = row + 1; col < dp[0].length; col++) {
                if (row - col == -1) {
                    dp[row][col] = 0;
                } else {
                    dp[row][col] = Integer.MAX_VALUE;
                    for (int k = 1; k < (col - row); k++) {
                        dp[row][col] = Math.min(dp[row][col], dp[row][row + k] + dp[row + k][col]);
                    }
                    int baseCost = costs[col] - costs[row];
                    dp[row][col] += baseCost;
                }
            }
        }
        return dp[0][dp[0].length - 1];
    }
}
