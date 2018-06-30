package come.class14_DP1;

public class Q2_MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        int[] stateArray = new int[length + 1];
        stateArray[0] = 0;
        stateArray[1] = 0;

        for (int i = 1; i < stateArray.length; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j, stateArray[j]) * (i - j));
            }
            stateArray[i] = max;
        }
        return stateArray[length];
    }



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
        Q2_MaxProductOfCuttingRope solution = new Q2_MaxProductOfCuttingRope();
        System.out.println(solution.maxProductI(5));
    }
}
