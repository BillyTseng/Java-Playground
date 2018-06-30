package come.class17_DP3.attempt04;

public class LargestXOf1s {
    public int largest(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] leftUp = buildLeftUp(matrix, m, n);
        int[][] rightDown = buildRightDown(matrix, m, n);
        return merge(leftUp, rightDown, m, n);
    }

    private int getNumber(int[][] input, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        return input[i][j];
    }

    private int merge(int[][] tar, int[][] src, int m, int n) {
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tar[i][j] = Math.min(tar[i][j], src[i][j]);
                max = Math.max(max, tar[i][j]);
            }
        }
        return max;
    }

    private int[][] buildLeftUp(int[][] matrix, int m, int n) {
        int[][] left = new int[m][n];
        int[][] up = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    left[i][j] = getNumber(left, m, n, i - 1, j - 1) + 1;
                    up[i][j] = getNumber(up, m, n, i - 1, j + 1) + 1;
                }
            }
        }
        merge(left, up, m, n);
        return left;
    }

    private int[][] buildRightDown(int[][] matrix, int m, int n) {
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = getNumber(right, m, n, i + 1, j + 1) + 1;
                    down[i][j] = getNumber(down, m, n, i + 1, j - 1) + 1;
                }
            }
        }
        merge(right, down, m, n);
        return right;
    }
}
