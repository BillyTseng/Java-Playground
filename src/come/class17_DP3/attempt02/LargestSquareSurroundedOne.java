package come.class17_DP3.attempt02;

public class LargestSquareSurroundedOne {
    public int largest(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }

        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int max = 0;
        int[][] left = new int[m + 1][n + 1];
        int[][] up = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    left[i + 1][j + 1] = left[i + 1][j] + 1;
                    up[i + 1][j + 1] = up[i][j + 1] + 1;
                    for (int maxLength = Math.min(left[i + 1][j + 1], up[i + 1][j + 1]); maxLength >= 1; maxLength--) {
                        if (left[i + 1 - maxLength + 1][j + 1] >= maxLength &&
                                up[i + 1][j + 1 - maxLength + 1] >= maxLength) {
                            max = Math.max(max, maxLength);
                            break;
                        }
                    }
                }
            }
        }
        return max;
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
