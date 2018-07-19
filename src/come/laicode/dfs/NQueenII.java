package come.laicode.dfs;

public class NQueenII {
    public int totalNQueens(int n) {
        int[] total = new int[] {0};
        boolean[] usedCol = new boolean[n];
        boolean[] usedDiagl = new boolean[2 * n - 1];
        boolean[] usedRevDiagl = new boolean[2 * n - 1];

        totalNQueens(n, 0, total, usedCol, usedDiagl, usedRevDiagl);
        return total[0];
    }

    private void totalNQueens(int n, int row, int[] total,
                              boolean[] usedCol, boolean[] usedDiagl, boolean[] usedRevDiagl) {
        if (n == row) {
            total[0]++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(n, row, col, usedCol, usedDiagl, usedRevDiagl)) {
                mark(n, row, col, usedCol, usedDiagl, usedRevDiagl, true);
                totalNQueens(n, row + 1, total, usedCol, usedDiagl, usedRevDiagl);
                mark(n, row, col, usedCol, usedDiagl, usedRevDiagl, false);
            }
        }
    }

    private boolean isValid(int n, int row, int col,
                            boolean[] usedCol, boolean[] usedDiagl, boolean[] usedRevDiagl) {
        return !usedCol[col] && !usedDiagl[col + row] && !usedRevDiagl[col - row + n - 1];
    }

    private void mark(int n, int row, int col,
                      boolean[] usedCol, boolean[] usedDiagl, boolean[] usedRevDiagl, boolean marker) {
        usedCol[col] = marker;
        usedDiagl[col + row] = marker;
        usedRevDiagl[col - row + n - 1] = marker;
    }
}
