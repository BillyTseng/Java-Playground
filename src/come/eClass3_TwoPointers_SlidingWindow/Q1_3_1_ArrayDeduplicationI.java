package come.eClass3_TwoPointers_SlidingWindow;

import java.util.Arrays;

public class Q1_3_1_ArrayDeduplicationI {
    public int[] dedup(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = 1;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[fast] != array[slow - 1]) {
                array[slow++] = array[fast];
            }
        }
        return Arrays.copyOf(array, slow);
    }
}
