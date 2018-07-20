package come.laicode.dfs;

public class NumberOfIslands {
    private final char LAND = '1';
    private final char WATER = '0';

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int numOfIslands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == LAND) {
                    numOfIslands++;
                    merge(grid, i, j);
                }
            }
        }
        return numOfIslands;
    }

    private void merge(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != LAND) {
            return;
        }

        grid[x][y] = 'X';
        merge(grid, x + 1, y);
        merge(grid, x - 1, y);
        merge(grid, x, y + 1);
        merge(grid, x, y - 1);
    }
}
