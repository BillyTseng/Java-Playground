package come.Freq;

import java.util.Arrays;

/**
 * 322. Coin Change - medium
 */

public class Q14_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] g = new int[amount + 1];
        Arrays.fill(g, Integer.MAX_VALUE);
        g[0] = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i]) {
                    g[j] = Math.min(g[j], g[j - coins[i]] + 1);
                }
            }
        }
        return (g[amount] == Integer.MAX_VALUE) ? -1 : g[amount];
    }
}
