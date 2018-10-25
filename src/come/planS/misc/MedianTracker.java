package come.planS.misc;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianTracker {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    public MedianTracker() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void read(int value) {
        if (small.isEmpty() || value <= small.peek()) {
            small.offer(value);
        } else {
            large.offer(value);
        }

        if (small.size() - large.size() > 1) {
            large.offer(small.poll());
        } else if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public Double median() {
        int size = small.size() + large.size();
        if (size == 0) {
            return null;
        } else if (size % 2 == 0) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek() * 1.0;
        }
    }
}
