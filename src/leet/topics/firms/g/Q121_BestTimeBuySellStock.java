package leet.topics.firms.g;

public class Q121_BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else if (maxProfit < prices[i] - minValue) {
                maxProfit = prices[i] - minValue;
            }
        }
        return maxProfit;
    }
}
