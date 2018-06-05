package come.class13.attempt01;

public class LargestSquareOf1s {
    private int largest(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] squares = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    squares[i][j] = matrix[i][j];
                } else if (matrix[i][j] == 1) {
                    squares[i][j] = Math.min(squares[i - 1][j], squares[i][j - 1]);
                    squares[i][j] = Math.min(squares[i][j], squares[i - 1][j - 1]);
                    squares[i][j] += 1;
                }
                max = Math.max(max, squares[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LargestSquareOf1s solution = new LargestSquareOf1s();
        System.out.println(solution.largest(new int[][]{ {0, 0, 0, 0},
                                                         {1, 1, 1, 1},
                                                         {0, 1, 1, 1},
                                                         {1, 0, 1, 1}}));
    }
}
