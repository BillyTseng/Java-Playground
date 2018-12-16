package leet.topics.firms.g;

public class Q309_BestTimeBuySellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // the profit of buy or not buy in ith day
        int[] hold = new int[n];
        // the profit of sell or not sell in ith day
        int[] unhold = new int[n];
        // base case 1
        hold[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (i == 1) {
                // base case 2
                hold[i] = Math.max(hold[i - 1], -prices[i]);
            } else {
                hold[i] = Math.max(unhold[i - 2] - prices[i], hold[i - 1]);
            }

            unhold[i] = Math.max(hold[i - 1] + prices[i], unhold[i - 1]);
        }
        return unhold[n - 1];
    }
}
