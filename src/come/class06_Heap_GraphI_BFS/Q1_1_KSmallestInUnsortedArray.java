package come.class06_Heap_GraphI_BFS;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q1_1_KSmallestInUnsortedArray {
    public int[] kSmallestByMaxHeap(int[] array, int k) {
        if (array == null || array.length <= 0 || k == 0) {
            return new int[0];
        }
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
}
