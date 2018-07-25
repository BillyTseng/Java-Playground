package come.eClass3_TwoPointers_SlidingWindow;

import java.util.Arrays;

public class Q1_3_3_ArrayDeduplicationIII {
    public int[] dedup(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            int begin = fast;
            while (fast < array.length && array[begin] == array[fast]) {
                fast++;
            }
            if (fast - begin == 1) {
                array[slow++] = array[fast];
            }
        }
        return Arrays.copyOf(array, slow);
    }
}
