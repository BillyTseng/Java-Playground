package come.planS.dp;

public class BuyStockI {
    public int maxProfit(int[] array) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int anArray : array) {
            if (anArray < min) {
                min = anArray;
            } else if (maxProfit < anArray - min) {
                maxProfit = anArray - min;
            }
        }
        return maxProfit;
    }
}
