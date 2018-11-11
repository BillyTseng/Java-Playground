package leet.topics.firms.a.freq;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q130_SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        verifyBorder(board, m, n);

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        int index = i * n + j;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(index);
        board[i][j] = '1';

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int x = curr / n;
            int y = curr % n;

            if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                board[x - 1][y] = '1';
                queue.offer((x - 1) * n + y);
            }

            if (x + 1 < m && board[x + 1][y] == 'O') {
                board[x + 1][y] = '1';
                queue.offer((x + 1) * n + y);
            }

            if (y - 1 >= 0 && board[x][y - 1] == 'O') {
                board[x][y - 1] = '1';
                queue.offer(x * n + (y - 1));
            }

            if (y + 1 < n && board[x][y + 1] == 'O') {
                board[x][y + 1] = '1';
                queue.offer(x * n + (y + 1));
            }
        }
    }

    private void verifyBorder(char[][] board, int m, int n) {
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[m - 1][j] == 'O') {
                bfs(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
        }

        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                bfs(board, i, n - 1);
            }
        }
    }
}
