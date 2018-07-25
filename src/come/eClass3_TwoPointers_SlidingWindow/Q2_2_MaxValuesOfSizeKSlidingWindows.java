package come.eClass3_TwoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q2_2_MaxValuesOfSizeKSlidingWindows {
    public List<Integer> maxWindows(int[] array, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            while (!deque.isEmpty() && array[i] >= array[deque.peekLast()]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res.add(array[deque.peekFirst()]);
            }
        }
        return res;
    }
}
