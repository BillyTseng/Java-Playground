package come.class12.attempt01;

public class MaxProductOfCuttingRope {
    private int maxProductI(int length) {
        if (length <= 1) {
            return 0;
        }
        int maxProduct = 0;
        for (int i = 1; i < length; i++) {
            int best = Math.max(length - i, maxProductI(length - i));
            maxProduct = Math.max(maxProduct, i * best);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        MaxProductOfCuttingRope solution = new MaxProductOfCuttingRope();
        System.out.println(solution.maxProductI(5));
    }
}
