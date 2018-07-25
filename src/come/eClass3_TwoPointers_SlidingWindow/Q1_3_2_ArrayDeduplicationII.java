package come.eClass3_TwoPointers_SlidingWindow;

import java.util.Arrays;

public class Q1_3_2_ArrayDeduplicationII {
    public int[] dedup(int[] array) {
        if (array.length <= 2) {
            return array;
        }
        int slow = 2;
        for (int fast = 2; fast < array.length; fast++) {
            if (array[fast] != array[slow - 2]) {
                array[slow++] = array[fast];
            }
        }
        return Arrays.copyOf(array, slow);
    }
}
