package come.class05.attempt02;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallestInUnsortedArray {
    public int[] kSmallestI(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : array) {
            minHeap.offer(num);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    public int[] kSmallestII(int[] array, int k) {
        if (array == null || array.length == 0 || k <= 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new maxComparator());
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
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

    private class maxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer e1, Integer e2) {
            if (e1.equals(e2)) {
                return 0;
            }
            return e1 > e2 ? -1 : 1;
        }
    }
}
