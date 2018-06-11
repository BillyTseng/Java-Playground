package come.class15.attempt01;

// Can't find the online assessment.
public class LargestSquareSurroundedOne {
    private int largest(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }

        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }

        int[][] rightToLeft = getRightToLeft(matrix, m, n);
        int[][] bottomToTop = getBottomToTop(matrix, m, n);
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // loop through the possible length of edge
                int length = Math.min(m, n);
                for (int k = length; k >= 1; k--) {
                    if (rightToLeft[i][j] >= k && j + k - 1 < n &&
                            bottomToTop[i][j] >= k && i + k - 1 < m &&
                            bottomToTop[i][j + k - 1] >= k &&
                            rightToLeft[i + k - 1][j] >= k) {
                        max = Math.max(max, k);
                        break;
                    }
                }
            }
        }
        return max;
    }

    private int[][] getRightToLeft(int[][] matrix, int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    res[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    res[i][j] = 1 + res[i][j + 1];
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return res;
    }

    private int[][] getBottomToTop(int[][] matrix, int m, int n) {
        int[][] res = new int[m][n];
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (i == m - 1) {
                    res[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    res[i][j] = 1 + res[i + 1][j];
                } else {
                    res[i][j] = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LargestSquareSurroundedOne solution = new LargestSquareSurroundedOne();
        System.out.println(solution.largest(new int[][]{ {1, 0, 1, 1, 1},
                                                         {1, 1, 1, 1, 1},
                                                         {1, 1, 0, 1, 0},
                                                         {1, 1, 1, 1, 1},
                                                         {1, 1, 1, 0, 0}}));
    }
}
