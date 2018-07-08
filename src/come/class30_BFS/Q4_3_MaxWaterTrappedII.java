package come.class30_BFS;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q4_3_MaxWaterTrappedII {
    public int maxTrapped(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows < 3 || cols < 3) {
            return 0;
        }

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        boolean[][] visited = new boolean[rows][cols];
        processBorder(matrix, visited, minHeap, rows, cols);
        int result = 0;
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            List<Pair> neighbors = getAllNeighbors(cur, matrix);

            for (Pair neighbor : neighbors) {
                if (visited[neighbor.row][neighbor.col]) {
                    continue;
                }
                visited[neighbor.row][neighbor.col] = true;
                result += Math.max(cur.height - neighbor.height, 0);
                neighbor.height = Math.max(cur.height, neighbor.height);
                minHeap.offer(neighbor);
            }
        }
        return result;
    }

    private List<Pair> getAllNeighbors(Pair cur, int[][] matrix) {
        List<Pair> neighbors = new ArrayList<>();
        if (cur.row + 1 < matrix.length) {
            neighbors.add(new Pair(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
        }
        if (cur.row - 1 >= 0) {
            neighbors.add(new Pair(cur.row - 1, cur.col, matrix[cur.row - 1][cur.col]));
        }
        if (cur.col + 1 < matrix[0].length) {
            neighbors.add(new Pair(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
        }
        if (cur.col - 1 >= 0) {
            neighbors.add(new Pair(cur.row, cur.col - 1, matrix[cur.row][cur.col - 1]));
        }
        return neighbors;
    }

    private void processBorder(int[][] matrix, boolean[][] visited, PriorityQueue<Pair> minHeap, int rows, int cols) {
        for (int j = 0; j < cols; j++) {
            minHeap.offer(new Pair(0, j, matrix[0][j]));
            visited[0][j] = true;
            minHeap.offer(new Pair(rows - 1, j, matrix[rows - 1][j]));
            visited[rows - 1][j] = true;
        }

        for (int i = 1; i < rows - 1; i++) {
            minHeap.offer(new Pair(i, 0, matrix[i][0]));
            visited[i][0] = true;
            minHeap.offer(new Pair(i, cols - 1, matrix[i][cols - 1]));
            visited[i][cols - 1] = true;
        }
    }

    class Pair implements Comparable<Pair> {
        int row;
        int col;
        int height;

        Pair(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public int compareTo(Pair another) {
            if (this.height == another.height) {
                return 0;
            }
            return this.height < another.height ? -1 : 1;
        }
    }
}
