/*  A = {1, 2, 3}, B = {100, 200}, K = 2
*   Result: A[0] + B[1] = 201, A[1] + B[0] = 102
* */

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class KSmallestSumFromTwoSortedArray {
    public int kSmallest(int[] A, int[] B, int k) {
        int m = A.length;
        int n = B.length;
        Set<Cell> visited = new HashSet<>();
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(new CellComparator());
        Cell cur = new Cell(0, 0, A[0] + B[0]);
        minHeap.offer(cur);
        visited.add(cur);
        int sum = A[0] + B[0];
        for (int i = 0; i < k; i++) {
            cur = minHeap.poll();
            sum = cur.sum;
            if (cur.x < m - 1) {
                Cell next = new Cell(cur.x + 1, cur.y, A[cur.x + 1] + B[cur.y]);
                if (visited.add(next)) {
                    minHeap.offer(next);
                }
            }

            if (cur.y < n - 1) {
                Cell next = new Cell(cur.x, cur.y + 1, A[cur.x] + B[cur.y + 1]);
                if (visited.add(next)) {
                    minHeap.offer(next);
                }
            }
        }
        return sum;
    }

    private class CellComparator implements Comparator<Cell> {
        @Override
        public int compare(Cell o1, Cell o2) {
            if (o1.sum == o2.sum) {
                return 0;
            }
            return o1.sum < o2.sum ? -1 : 1;
        }
    }

    private class Cell {
        int x;
        int y;
        int sum;

        Cell(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        KSmallestSumFromTwoSortedArray solution = new KSmallestSumFromTwoSortedArray();
        int[] A = {1, 2, 3}, B = {100, 200};
        solution.kSmallest(A, B, 2);
    }
}
