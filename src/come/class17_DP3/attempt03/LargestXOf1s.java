package come.class17_DP3.attempt03;

public class LargestXOf1s {
    public int largest(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] leftUp = buildLeftUp(matrix, m, n);
        int[][] rightDown = buildRightDown(matrix, m, n);
        return merge(leftUp, rightDown, m, n);
    }

    private int getNumber(int[][] input, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }
        return input[i][j];
    }

    private int merge(int[][] tar, int[][] src, int m , int n) {
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tar[i][j] = Math.min(tar[i][j], src[i][j]);
                max = Math.max(max, tar[i][j]);
            }
        }
        return max;
    }

    private int[][] buildLeftUp(int[][] matrix, int m , int n) {
        int[][] left = new int[m][n];
        int[][] up = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    left[i][j] = getNumber(left, i - 1, j - 1, m, n) + 1;
                    up[i][j] = getNumber(up, i - 1, j + 1, m, n) + 1;
                }
            }
        }
        merge(left, up, m, n);
        return left;
    }

    private int[][] buildRightDown(int[][] matrix, int m , int n) {
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    right[i][j] = getNumber(right, i + 1, j + 1, m, n) + 1;
                    down[i][j] = getNumber(down, i + 1, j - 1, m, n) + 1;
                }
            }
        }
        merge(right, down, m, n);
        return right;
    }
}
