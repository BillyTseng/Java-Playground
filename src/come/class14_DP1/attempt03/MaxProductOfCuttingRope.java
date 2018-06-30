package come.class14_DP1.attempt03;

public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        int[] product = new int[length + 1];
        product[0] = 0;
        product[1] = 0;
        for (int i = 2; i <= length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 1; j--) {
                int tempProduct = Math.max(j, product[j]) * (i - j);
                max = Math.max(max, tempProduct);
            }
            product[i] = max;
        }
        return product[length];
    }
}
