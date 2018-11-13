package leet;

import java.util.HashSet;
import java.util.Set;

public class Q36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        return validRows(board) && validColumns(board) && validGrids(board);
    }

    private boolean validRows(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validColumns(char[][] board) {
        for (int j = 0; j < board[0].length; j++) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validGrids(char[][] board) {
        for (int k = 0; k < 9; k++) {
            int rowOffset = k / 3;
            int colOffset = k % 3;
            Set<Character> set = new HashSet<>();
            for (int i = rowOffset * 3; i < (3 + rowOffset * 3); i++) {
                for (int j = colOffset * 3; j < (3 + colOffset * 3); j++) {
                    if (board[i][j] != '.' && !set.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
