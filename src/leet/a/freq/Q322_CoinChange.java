package leet.a.freq;

import java.util.Arrays;

//  f 0 1 2 3 4 5 6 7 8 9 10 11
//  1 0 0 1 2 3 4 5 6 7 8  9 10
//  2     0 1 2 3 4 5 6 7  8  9
//  5           0 1 2 3 4  5  6
//1+m 0 1 1 2 2 1 2 2 3 3  2  3

public class Q322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return (dp[amount] > amount) ? -1 : dp[amount];
    }
}
