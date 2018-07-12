package come.class26_BST_DP;

public class Q4_2_MergeStones {
    public int minCost(int[] stones) {
        int len = stones.length;
        int[][] cost = new int[len][len];
        int[][] subSum = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    cost[j][i] = 0;
                    subSum[j][i] = stones[i];
                } else {
                    subSum[j][i] = subSum[j][i - 1] + stones[i];
                    cost[j][i] = Integer.MAX_VALUE;
                    for (int k = j; k < i; k++) {
                        cost[j][i] = Math.min(cost[j][i], cost[j][k] + cost[k + 1][i] + subSum[j][i]);
                    }
                }
            }
        }
        return cost[0][len - 1];
    }
}
