package come.class13.attempt03;

public class LargestSquareOf1s {
    public int largest(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] lens = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    lens[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    lens[i][j] = Math.min(lens[i - 1][j - 1], lens[i - 1][j]);
                    lens[i][j] = Math.min(lens[i][j], lens[i][j - 1]);
                    lens[i][j] += 1;
                }
                max = Math.max(max, lens[i][j]);
            }
        }
        return max;
    }
}
