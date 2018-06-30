package come.class14_DP1.attempt02;

public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        int[] m = new int[length + 1];
        m[1] = 0;
        for (int i = 2; i < m.length; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                int maxProduct = Math.max(j, m[j]) * (i - j);
                max = Math.max(max, maxProduct);
            }
            m[i] = max;
        }
        return m[length];
    }
}
