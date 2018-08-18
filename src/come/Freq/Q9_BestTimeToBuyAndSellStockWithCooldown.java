package come.Freq;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown - medium
 */

public class Q9_BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int[] hold = new int[n];
        int[] unhold = new int[n];

        hold[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            // Math.max(do nothing, hold or unhold stocks)
            if (i == 1) {
                hold[i] = Math.max(hold[i - 1], -prices[i]);
            } else {
                hold[i] = Math.max(hold[i - 1], unhold[i - 2] - prices[i]);
            }

            unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i]);
        }

        return unhold[n - 1];
    }
}
