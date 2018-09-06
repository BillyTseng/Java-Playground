package come.eClass3_TwoPointers_SlidingWindow.attempt02;

import java.util.*;

public class Q2_2_MaxValuesOfSizeKSlidingWindows {
    public List<Integer> maxWindows(int[] array, int k) {
        // Write your solution here
        List<Integer> max = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            while (!deque.isEmpty() && array[deque.peekLast()] <= array[i]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offerLast(i);

            if (i >= k - 1) {
                max.add(array[deque.peekFirst()]);
            }
        }
        return max;
    }
}
