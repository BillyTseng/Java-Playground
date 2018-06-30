package come.class21_RecursionII.attempt02;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        boolean[] usedCol = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] revDiag = new boolean[2 * n - 1];
        List<List<Integer>> res = new ArrayList<>();
        int[] cur = new int[n];

        nqueens(0, n, cur, res, usedCol, diag, revDiag);
        return res;
    }

    private void nqueens(int row, int n, int[] cur, List<List<Integer>> res,
                         boolean[] usedCol, boolean[] diag, boolean[] revDiag) {
        if (row == n) {
            res.add(toList(cur));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(n, row, col, usedCol, diag, revDiag)) {
                cur[row] = col;
                mark(n, row, col, usedCol, diag, revDiag);
                nqueens(row + 1, n, cur, res, usedCol, diag, revDiag);
                unmark(n, row, col, usedCol, diag, revDiag);
            }
        }
    }

    private boolean isValid(int n, int row, int col, boolean[] usedCol, boolean[] diag, boolean[] revDiag) {
        return !usedCol[col] && !diag[row + col] && !revDiag[col - row + n - 1];
    }

    private void mark(int n, int row, int col, boolean[] usedCol, boolean[] diag, boolean[] revDiag) {
        usedCol[col] = true;
        diag[row + col] = true;
        revDiag[col - row + n - 1] = true;
    }

    private void unmark(int n, int row, int col, boolean[] usedCol, boolean[] diag, boolean[] revDiag) {
        usedCol[col] = false;
        diag[row + col] = false;
        revDiag[col - row + n - 1] = false;
    }

    private List<Integer> toList(int[] input) {
        List<Integer> ans = new ArrayList<>();
        for (int anInput : input) {
            ans.add(anInput);
        }
        return ans;
    }
}
