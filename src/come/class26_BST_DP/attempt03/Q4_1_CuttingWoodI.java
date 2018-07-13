package come.class26_BST_DP.attempt03;

public class Q4_1_CuttingWoodI {
    public int minCost(int[] cuts, int length) {
        int[] allCuts = new int[cuts.length + 2];
        allCuts[0] = 0;
        for (int i = 0; i < cuts.length; i++) {
            allCuts[i + 1] = cuts[i];
        }
        allCuts[allCuts.length - 1] = length;

        int[][] minCost = new int[allCuts.length][allCuts.length];
        for (int row = minCost.length - 2; row >= 0; row--) {
            for (int col = row + 1; col < minCost[0].length; col++) {
                if (row - col == -1) {
                    minCost[row][col] = 0;
                } else {
                    minCost[row][col] = Integer.MAX_VALUE;
                    for (int k = 1; k < col - row; k++) {
                        minCost[row][col] = Math.min(minCost[row][col], minCost[row][row + k] + minCost[row + k][col]);
                    }
                    int baseCost = allCuts[col] - allCuts[row];
                    minCost[row][col] += baseCost;
                }
            }
        }
        return minCost[0][minCost[0].length - 1];
    }
}
