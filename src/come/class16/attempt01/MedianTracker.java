package come.class16.attempt01;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianTracker {

}

class Solution {
    private PriorityQueue<Integer> largerHalf;
    private PriorityQueue<Integer> smallerHalf;
    public Solution() {
        largerHalf = new PriorityQueue<>();
        smallerHalf = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void read(int value) {
        if (smallerHalf.isEmpty() || value <= smallerHalf.peek()) {
            smallerHalf.offer(value);
        } else {
            largerHalf.offer(value);
        }

        if ((smallerHalf.size() - largerHalf.size()) > 1) {
            largerHalf.offer(smallerHalf.poll());
        } else if (largerHalf.size() > smallerHalf.size()) {
            smallerHalf.offer(largerHalf.poll());
        }

    }

    public Double median() {
        int size = size();
        if (size == 0) {
            return null;
        } else if (size() % 2 == 0) {
            return (smallerHalf.peek() + largerHalf.peek()) / 2.0;
        } else {
            return (double) smallerHalf.peek();
        }
    }

    private int size() {
        return largerHalf.size() + smallerHalf.size();
    }
}
