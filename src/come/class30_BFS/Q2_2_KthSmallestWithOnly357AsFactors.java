package come.class30_BFS;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Q2_2_KthSmallestWithOnly357AsFactors {
    public long kth(int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>(k);
        Set<Long> visited = new HashSet<>();
        minHeap.offer(3 * 5 * 7L);
        visited.add(3 * 5 * 7L);
        while (k > 1) {
            long curr = minHeap.poll();
            if (visited.add(3 * curr)) {
                minHeap.offer(3 * curr);
            }
            if (visited.add(5 * curr)) {
                minHeap.offer(5 * curr);
            }
            if (visited.add(7 * curr)) {
                minHeap.offer(7 * curr);
            }
            k--;
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Q2_2_KthSmallestWithOnly357AsFactors solution = new Q2_2_KthSmallestWithOnly357AsFactors();
        System.out.println(solution.kth(40));
    }
}
