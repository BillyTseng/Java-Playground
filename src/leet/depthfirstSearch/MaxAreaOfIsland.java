package leet.depthfirstSearch;
/* 695.	Max Area of Island - easy */
public class MaxAreaOfIsland {
    private final int ISLAND = 1;

    public int maxAreaOfIsland(int[][] grid) {
        int globalMax = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int[] maxArea = {0};
                if (grid[i][j] == ISLAND && !visited[i][j]) {
                    dfs(grid, i, j, maxArea, visited);
                }
                globalMax = Math.max(globalMax, maxArea[0]);
            }
        }

        return globalMax;
    }

    private void dfs(int[][] grid, int row, int col, int[] maxArea, boolean[][] visited) {
        int[] rowOffset = {0, 1, 0, -1};
        int[] colOffset = {1, 0, -1, 0};
        maxArea[0] += 1;
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow >= 0 && newRow < grid.length &&
                    newCol >= 0 && newCol < grid[0].length &&
                    grid[newRow][newCol] == ISLAND && !visited[newRow][newCol]) {
                dfs(grid, newRow, newCol, maxArea, visited);
            }
        }
    }
}
