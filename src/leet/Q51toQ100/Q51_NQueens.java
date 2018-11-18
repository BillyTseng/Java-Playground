package leet.Q51toQ100;

import java.util.ArrayList;
import java.util.List;

public class Q51_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        search(res, n, new ArrayList<>());
        return res;
    }

    private void search(List<List<String>> res, int n, List<Integer> cols) {
        if (cols.size() == n) {
            res.add(drawChessboard(cols));
            return;
        }

        for (int colIdx = 0; colIdx < n; colIdx++) {
            if (!isValid(cols, colIdx)) {
                continue;
            }

            cols.add(colIdx);
            search(res, n, cols);
            cols.remove(cols.size() - 1);
        }
    }

    private List<String> drawChessboard(List<Integer> cols) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(cols.get(i) == j ? 'Q' : '.');
            }
            board.add(sb.toString());
        }
        return board;
    }

    private boolean isValid(List<Integer> cols, int column) {
        int row = cols.size();
        for (int i = 0; i < cols.size(); i++) {
            if (cols.get(i) == column) {
                return false;
            }
            if (i + cols.get(i) == row + column) {
                return false;
            }

            if (i - cols.get(i) == row - column) {
                return false;
            }
        }

        return true;
    }
}
