package come.eClass3_TwoPointers_SlidingWindow;

import java.util.Arrays;

public class Q1_3_5_ArrayDeduplicationV {
    public int[] dedup(int[] array) {
        if (array.length <= 2) {
            return array;
        }
        int slow = 2;
        for (int fast = 2; fast < array.length; fast++) {
            if (array[slow - 2] == array[fast] && array[fast] == array[fast - 1]) {
                continue;
            }
            array[slow++] = array[fast];
        }
        return Arrays.copyOf(array, slow);
    }
}
