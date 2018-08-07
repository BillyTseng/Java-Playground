package come.eClass8_DP;

public class Q3_2_LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        // The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
        int res = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int[] singleRowSum = new int[n];
            for (int j = i; j < m; j++) {
                getSingleRowSum(matrix[j], singleRowSum);
                res = Math.max(res, getMaxSingleRowSum(singleRowSum));
            }
        }
        return res;
    }

    private void getSingleRowSum(int[] input, int[] output) {
        for (int i = 0; i < output.length; i++) {
            output[i] += input[i];
        }
    }

    private int getMaxSingleRowSum(int[] input) {
        int prevSum = input[0];
        int res = input[0];

        for (int i = 1; i < input.length; i++) {
            if (prevSum < 0) {
                prevSum = input[i];
            } else {
                prevSum += input[i];
            }
            res = Math.max(res, prevSum);
        }
        return res;
    }
}
