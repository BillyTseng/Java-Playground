package come.class17_DP3;

public class Q5_LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] singleRowSum = new int[n];
            for (int j = i; j < m; j++) {
                calSingleRowSum(matrix[j], singleRowSum);
                max = Math.max(max, getMaxSingleRowSum(singleRowSum));
            }
        }
        return max;
    }

    private void calSingleRowSum(int[] input, int[] singleRowSum) {
        for (int i = 0; i < singleRowSum.length; i++) {
            singleRowSum[i] += input[i];
        }
    }

    private int getMaxSingleRowSum(int[] input) {
        int max = input[0];
        int prevSum = input[0];
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
