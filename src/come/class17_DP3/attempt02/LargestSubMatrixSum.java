package come.class17_DP3.attempt02;

public class LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        // assumptions: The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] singleRowSum = new int[n];
            for (int j = i; j < m; j++) {
                calSingleRowSum(matrix[j], singleRowSum);
                max = Math.max(max, getMaxSum(singleRowSum));
            }
        }
        return max;
    }

    private void calSingleRowSum(int[] input, int[] singleRowSum) {
        for (int i = 0; i < input.length; i++) {
            singleRowSum[i] += input[i];
        }
    }

    private int getMaxSum(int[] input) {
        int prevSum = input[0];
        int max = input[0];
        for (int i = 1; i < input.length; i++) {
            if (prevSum < 0) {
                prevSum = input[i];
            } else {
                prevSum += input[i];
            }
            max = Math.max(max, prevSum);
        }
        return max;
    }
}
