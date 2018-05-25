package come.class05.attempt02;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(new cellComparator());
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        for (int i = 0; i < k -1; i++) {
            Cell curr = minHeap.poll();
            if (curr.row + 1 < rows && !visited[curr.row + 1][curr.col]) {
                minHeap.offer(new Cell(curr.row + 1, curr.col, matrix[curr.row + 1][curr.col]));
                visited[curr.row + 1][curr.col] = true;
            }

            if (curr.col + 1 < cols && !visited[curr.row][curr.col + 1]) {
                minHeap.offer(new Cell(curr.row, curr.col + 1, matrix[curr.row][curr.col + 1]));
                visited[curr.row][curr.col + 1] = true;
            }
        }
        return minHeap.peek().value;
    }

    private class cellComparator implements Comparator<Cell> {
        @Override
        public int compare(Cell c1, Cell c2) {
            if (c1.value == c2.value) {
                return 0;
            }
            return c1.value < c2.value ? -1 : 1;
        }
    }

    private class Cell {
        private int row;
        private int col;
        private int value;

        public Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}
