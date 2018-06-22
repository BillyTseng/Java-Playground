package come.class15.attempt03;

public class LargestSubMatrixSum {
    public int largest(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                getSingleRowSum(matrix[j], sum, n);
                max = Math.max(max, getLargestSum(sum));
            }
        }
        return max;
    }

    private void getSingleRowSum(int[] input, int[] sum, int n) {
        for (int i = 0; i < n; i++) {
            sum[i] += input[i];
        }
    }

    private int getLargestSum(int[] input) {
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
