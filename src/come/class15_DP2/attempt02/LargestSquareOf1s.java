package come.class15_DP2.attempt02;

public class LargestSquareOf1s {
    public int largest(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[][] squares = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    squares[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    squares[i][j] = Math.min(squares[i - 1][j], squares[i][j - 1]);
                    squares[i][j] = Math.min(squares[i - 1][j - 1], squares[i][j]);
                    squares[i][j] += 1;
                }
                max = Math.max(max, squares[i][j]);
            }
        }
        return max;
    }
}
