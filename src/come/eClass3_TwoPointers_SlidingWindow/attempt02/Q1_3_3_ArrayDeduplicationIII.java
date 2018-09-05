package come.eClass3_TwoPointers_SlidingWindow.attempt02;

import java.util.Arrays;

public class Q1_3_3_ArrayDeduplicationIII {
    public int[] dedup(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int slow = 0, fast = 0;
        while (fast < array.length) {
            int begin = fast;
            while (fast < array.length && array[fast] == array[begin]) {
                fast++;
            }
            if (fast - begin == 1) {
                array[slow++] = array[begin];
            }
        }
        return Arrays.copyOf(array, slow);
    }
}
