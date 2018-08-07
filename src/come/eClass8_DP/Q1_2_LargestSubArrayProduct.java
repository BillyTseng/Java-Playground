package come.eClass8_DP;

public class Q1_2_LargestSubArrayProduct {
    public double largestProduct(double[] array) {
        // The given array is not null and has length of at least 1.
        double res, currMax, currMin;
        res = currMax = currMin = array[0];

        for (int i = 1; i < array.length; i++) {
            double temp = currMax;
            currMax = Math.max(array[i], Math.max(array[i] * currMax, array[i] * currMin));
            currMin = Math.min(array[i], Math.min(array[i] * temp, array[i] * currMin));

            res = Math.max(res, currMax);
        }
        return res;
    }
}
