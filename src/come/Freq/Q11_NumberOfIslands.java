package come.Freq;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands - medium
 */

public class Q11_NumberOfIslands {
    private static final char LAND = '1';
    private static final char WATER = '0';
    private static final char VISITED = 'x';
    private static final int[][] DIRS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == LAND) {
                    // Both of the dfs and bfs are accepted.
                    bfsFindIsland(i, j, grid);
                    // dfsFindIsland(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsFindIsland(int i, int j, char[][] grid) {
        if (!isValidLAND(i, j, grid)) {
            return;
        }
        grid[i][j] = VISITED;
        for (int[] dir : DIRS) {
            int nextX = i + dir[0];
            int nextY = j + dir[1];
            dfsFindIsland(nextX, nextY, grid);
        }
    }

    private boolean isValidLAND(int x, int y, char[][] grid) {
        int m = grid.length, n = grid[0].length;
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == LAND;
    }

    private void bfsFindIsland(int i, int j, char[][] grid) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j, grid[i][j]));
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int[] dir : DIRS) {
                int nextX = cur.x + dir[0];
                int nextY = cur.y + dir[1];
                if (isValidLAND(nextX, nextY, grid)) {
                    Point next = new Point(nextX, nextY, grid[nextX][nextY]);
                    queue.offer(next);
                    grid[nextX][nextY] = VISITED;
                }
            }
        }
    }

    private class Point {
        int x;
        int y;
        char val;

        Point(int x, int y, char val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
