package come.class26_BST_DP.attempt02;

public class Q4_2_MergeStones {
    public int minCost(int[] stones) {
        int n = stones.length;
        int[][] minCost = new int[n][n];
        int[][] subSum = new int[n][n];

        for (int col = 0; col < n; col++) {
            for (int row = col; row >= 0; row--) {
                if (row == col) {
                    minCost[row][col] = 0;
                    subSum[row][col] = stones[col];
                } else {
                    subSum[row][col] = subSum[row][col - 1] + stones[col];
                    minCost[row][col] = Integer.MAX_VALUE;
                    for (int k = row; k < col; k++) {
                        minCost[row][col] = Math.min(minCost[row][col], minCost[row][k] + minCost[k + 1][col]);
                    }
                    minCost[row][col] += subSum[row][col];
                }
            }
        }
        return minCost[0][n - 1];
    }
}
