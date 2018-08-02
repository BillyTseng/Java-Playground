package come.eClass6_DFS_Graph;

import java.util.ArrayList;
import java.util.List;

public class Q8_PacificAtlanticWaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] touchPacific = new boolean[m][n];
        boolean[][] touchAtlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(matrix, touchPacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, touchAtlantic, Integer.MIN_VALUE, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            dfs(matrix, touchPacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, touchAtlantic, Integer.MIN_VALUE, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (touchPacific[i][j] && touchAtlantic[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private final int[][] DIRS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private boolean outMatrixBoundary(int[][] matrix, int x, int y) {
        return x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length;
    }

    private void dfs(int[][] matrix, boolean[][] visited, int prevHeight, int x, int y) {
        if (outMatrixBoundary(matrix, x, y) || visited[x][y] || matrix[x][y] < prevHeight) {
            return;
        }
        visited[x][y] = true;
        for (int[] DIR : DIRS) {
            dfs(matrix, visited, matrix[x][y], x + DIR[0], y + DIR[1]);
        }
    }
}
