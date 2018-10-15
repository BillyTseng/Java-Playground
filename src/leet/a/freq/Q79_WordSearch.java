package leet.a.freq;

public class Q79_WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 || board == null || board.length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        int m = board.length, n = board[0].length;
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#';
        if (dfs(board, word, i - 1, j, idx + 1) ||
                dfs(board, word, i + 1, j, idx + 1) ||
                dfs(board, word, i, j - 1, idx + 1) ||
                dfs(board, word, i, j + 1, idx + 1)) {
            board[i][j] = temp;
            return true;
        }
        board[i][j] = temp;
        return false;
    }
}
