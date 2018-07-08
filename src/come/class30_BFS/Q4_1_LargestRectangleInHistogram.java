package come.class30_BFS;

import java.util.Deque;
import java.util.LinkedList;

public class Q4_1_LargestRectangleInHistogram {
    public int largest(int[] array) {
        Deque<Integer> idxStack = new LinkedList<>();
        int max = 0;
        for (int i = 0; i <= array.length; i++) {
            int currHeight = i == array.length ? 0 : array[i];
            while (!idxStack.isEmpty() && array[idxStack.peekFirst()] >= currHeight) {
                int height = array[idxStack.pollFirst()];
                int left = idxStack.isEmpty() ? 0 : idxStack.peekFirst() + 1;
                max = Math.max(max, height * (i - left));
            }
            idxStack.offerFirst(i);
        }
        return max;
    }
}
