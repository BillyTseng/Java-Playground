package come.class05;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestNumberInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.val == c2.val) {
                    return 0;
                }
                return (c1.val - c2.val < 0) ? -1 : 1;
            }
        });
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        for (int i = 0; i < k - 1; i++) {
            Cell curr = minHeap.poll();
            if (curr.row + 1 < row && !visited[curr.row + 1][curr.col]) {
                visited[curr.row + 1][curr.col] = true;
                minHeap.offer(new Cell(curr.row + 1, curr.col, matrix[curr.row + 1][curr.col]));
            }
            if (curr.col + 1 < col && !visited[curr.row][curr.col + 1]) {
                visited[curr.row][curr.col + 1] = true;
                minHeap.offer(new Cell(curr.row, curr.col + 1, matrix[curr.row][curr.col + 1]));
            }
        }
        return minHeap.poll().val;
    }

    private class Cell {
        int row;
        int col;
        int val;
        Cell(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
