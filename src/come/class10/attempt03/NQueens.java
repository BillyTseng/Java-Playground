package come.class10.attempt03;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<Integer>> nQueens(int n) {
        int[] cur = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        boolean[] usedCol = new boolean[n];
        boolean[] usedDiag = new boolean[2 * n - 1];
        boolean[] usedRevDiag = new boolean[2 * n - 1];

        nQueens(0, n, cur, res, usedCol, usedDiag, usedRevDiag);
        return res;
    }

    private void nQueens(int row, int n, int[] cur, List<List<Integer>> res,
                         boolean[] usedCol, boolean[] usedDiag, boolean[] usedRevDiag) {
        if (row == n) {
            res.add(toList(cur));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, usedCol, usedDiag, usedRevDiag)) {
                cur[row] = col;
                mark(row, col, n, usedCol, usedDiag, usedRevDiag);
                nQueens(row + 1, n, cur, res, usedCol, usedDiag, usedRevDiag);
                unmark(row, col, n, usedCol, usedDiag, usedRevDiag);
            }
        }
    }

    private boolean isValid(int row, int col, int n,
                            boolean[] usedCol, boolean[] usedDiag, boolean[] usedRevDiag) {
        return !usedCol[col] && !usedDiag[col + row] && !usedRevDiag[col - row + n - 1];
    }

    private void mark(int row, int col, int n,
                      boolean[] usedCol, boolean[] usedDiag, boolean[] usedRevDiag) {
        usedCol[col] = true;
        usedDiag[col + row] = true;
        usedRevDiag[col - row + n - 1] = true;
    }

    private void unmark(int row, int col, int n,
                        boolean[] usedCol, boolean[] usedDiag, boolean[] usedRevDiag) {
        usedCol[col] = false;
        usedDiag[col + row] = false;
        usedRevDiag[col - row + n - 1] = false;
    }

    private List<Integer> toList(int[] input) {
        List<Integer> ans = new ArrayList<>();
        for (int anInput : input) {
            ans.add(anInput);
        }
        return ans;
    }
}
