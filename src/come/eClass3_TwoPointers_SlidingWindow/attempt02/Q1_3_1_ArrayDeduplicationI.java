package come.eClass3_TwoPointers_SlidingWindow.attempt02;

import java.util.Arrays;

public class Q1_3_1_ArrayDeduplicationI {
    public int[] dedup(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = 1;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[slow - 1] != array[fast]) {
                array[slow++] = array[fast];
            }
        }
        return Arrays.copyOf(array, slow);
    }
}
