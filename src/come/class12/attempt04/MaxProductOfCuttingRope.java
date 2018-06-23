package come.class12.attempt04;

public class MaxProductOfCuttingRope {
    public int maxProduct(int n) {
        int[] products = new int[n + 1];
        products[1] = 0;
        for (int i = 2; i < products.length; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                int temp = Math.max(j, products[j]) * (i - j);
                max = Math.max(max, temp);
            }
            products[i] = max;
        }
        return products[n];
    }
}
