package come.Freq;

/**
 * 518. Coin Change 2 - medium
 */

public class Q1_CoinChangeII {
    // n = coins.length, m = amount.
    // Method 1, time O(n*m^2), extra space O(n*m)
    public int change(int amount, int[] coins) {
        int[][] f = new int[coins.length + 1][amount + 1];
        f[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                for (int k = 0; k * coins[i - 1] <= j; k++) {
                    f[i][j] += f[i - 1][j - k * coins[i - 1]];
                }
            }
        }
        return f[coins.length][amount];
    }

    // Method 2, time O(nm), extra space O(nm)
    public int changeI(int amount, int[] coins) {
        int[][] f = new int[coins.length + 1][amount + 1];
        f[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                f[i][j] = f[i - 1][j] + (coins[i - 1] <= j ? f[i][j - coins[i - 1]] : 0);
            }
        }
        return f[coins.length][amount];
    }

    // Method 3, time O(nm), extra space O(m)
    public int changeII(int amount, int[] coins) {
        int[] g = new int[amount + 1];
        g[0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    g[j] += g[j - coins[i - 1]];
                }
            }
        }
        return g[amount];
    }
}
