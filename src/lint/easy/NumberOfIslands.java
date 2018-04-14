package lint.easy;

import java.util.LinkedList;
import java.util.Queue;

class Coordinate {
    int x;
    int y;
    Coordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class NumberOfIslands {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    markTraveled(grid, i, j);
                    island++;
                }
            }
        }
        return island;
    }

    private void markTraveled(boolean[][] grid, int i, int j) {
        int[] directionX = {1, 0, -1, 0};
        int[] directionY = {0, 1, 0, -1};

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(i, j));
        grid[i][j] = false; // mark traveled island as false;

        while (!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for (int idx = 0; idx < 4; idx++) {
                Coordinate newSpot = new Coordinate(
                        coor.x + directionX[idx], coor.y + directionY[idx]);
                if (!isBound(grid, newSpot)) {
                    continue;
                }
                if (grid[newSpot.x][newSpot.y]) {
                    // mark traveled island as false;
                    grid[newSpot.x][newSpot.y] = false;
                    queue.offer(newSpot);
                }
            }
        }
    }

    private boolean isBound(boolean[][] grid, Coordinate spot) {
        int m = grid.length;
        int n = grid[0].length;
        return spot.x >= 0 && spot.y >= 0 && spot.x < m && spot.y < n;
    }
}
