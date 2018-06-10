package come.class15.attempt01;

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

        int[][] upLeft = getUpLeft(matrix, m, n);
        int[][] downRight = getDownRight(matrix, m, n);
        return merge(upLeft, downRight, m, n);
    }

    private int getNumber(int[][] input, int i, int j, int m, int n) {
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

    private int[][] getUpLeft(int[][] matrix, int m, int n) {
        int[][] up = new int[m][n];
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    left[i][j] = getNumber(left, i - 1, j - 1, m, n) + 1;
                    up[i][j] = getNumber(left, i - 1, j + 1, m, n) + 1;
                }
            }
        }
        merge(up, left, m, n);
        return up;
    }

    private int[][] getDownRight(int[][] matrix, int m, int n) {
        int[][] down = new int[m][n];
        int[][] right = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = getNumber(right, i + 1, j + 1, m, n) + 1;
                    down[i][j] = getNumber(down, i + 1, j - 1, m, n) + 1;
                }
            }
        }
        merge(down, right, m, n);
        return down;
    }
}
