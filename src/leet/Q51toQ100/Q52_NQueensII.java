package leet.Q51toQ100;

public class Q52_NQueensII {
    private static int sum;
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        sum = 0;
        int[] cols = new int[n];
        search(cols, n, 0);
        return sum;
    }

    private void search(int[] cols, int n, int rowIdx) {
        if (rowIdx == n) {
            sum++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(cols, col, rowIdx)) {
                cols[rowIdx] = col;
                search(cols, n, rowIdx + 1);
            }
        }
    }

    private boolean isValid(int[] cols, int col, int row) {
        for (int i = 0; i < row; i++) {
            if (col == cols[i]) {
                return false;
            }

            if (row - i == Math.abs(col - cols[i])) {
                return false;
            }
        }
        return true;
    }
}
