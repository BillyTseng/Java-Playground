package come.class10.attempt01;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main (String[] args) {
        NQueensII solution = new NQueensII();
        solution.nqueens(4);
        System.out.println("done");
    }

    static class NQueensI {
        public List<List<Integer>> nqueens(int n) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            nqueens(res, cur, n);
            return res;
        }

        private void nqueens(List<List<Integer>> res, List<Integer> cur, int n) {
            if (cur.size() == n) {
                res.add(new ArrayList<>(cur));
                return;
            }

            for (int i = 0; i < n; i++) {
                if (isValid(cur, i)) {
                    cur.add(i);
                    nqueens(res, cur, n);
                    cur.remove(cur.size() - 1);
                }
            }
        }

        private boolean isValid(List<Integer> cur, int col) {
            int row = cur.size();
            for (int i = 0; i < row; i++) {
                if (cur.get(i) == col || Math.abs(cur.get(i) - col) == row - i) {
                    return false;
                }
            }
            return true;
        }
    }

    static class NQueensII {
        public List<List<Integer>> nqueens(int n) {
            List<List<Integer>> res = new ArrayList<>();
            int[] cur = new int[n];
            boolean[] usedCol = new boolean[n];
            boolean[] usedDiagonals = new boolean[2 * n - 1];
            boolean[] usedRevDiagonals = new boolean[2 * n - 1];
            nqueens(res, cur, n, 0, usedCol, usedDiagonals, usedRevDiagonals);
            return res;
        }

        private void nqueens(List<List<Integer>> res, int[] cur, int n, int row,
                             boolean[] usedCol, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
            if (row == n) {
                res.add(toList(cur));
                return;
            }

            for (int col = 0; col < n; col++) {
                if (isValid(n, row, col, usedCol, usedDiagonals, usedRevDiagonals)) {
                    mark(n, row, col, usedCol, usedDiagonals, usedRevDiagonals);
                    cur[row] = col;
                    nqueens(res, cur, n, row + 1, usedCol, usedDiagonals, usedRevDiagonals);
                    unmark(n, row, col, usedCol, usedDiagonals, usedRevDiagonals);
                }
            }
        }

        private boolean isValid(int n, int row, int col,
                                boolean[] usedCol, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
            return !usedCol[col] && !usedDiagonals[col + row] && !usedRevDiagonals[col - row + n - 1];
        }

        private void mark(int n, int row, int col,
                          boolean[] usedCol, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
            usedCol[col] = true;
            usedDiagonals[col + row] = true;
            usedRevDiagonals[col - row + n - 1] = true;
        }

        private void unmark(int n, int row, int col,
                            boolean[] usedCol, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
            usedCol[col] = false;
            usedDiagonals[col + row] = false;
            usedRevDiagonals[col - row + n - 1] = false;
        }

        private List<Integer> toList(int[] cur) {
            List<Integer> res = new ArrayList<>();
            for (int i : cur) {
                res.add(i);
            }
            return res;
        }
    }
}


