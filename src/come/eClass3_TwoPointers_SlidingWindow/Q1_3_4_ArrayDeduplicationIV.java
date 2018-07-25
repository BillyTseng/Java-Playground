package come.eClass3_TwoPointers_SlidingWindow;

import java.util.Arrays;

public class Q1_3_4_ArrayDeduplicationIV {
    public int[] dedup(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = -1;
        for (int fast = 0; fast < array.length; fast++) {
            if (slow == -1 || array[slow] != array[fast]) {
                array[++slow] = array[fast];
            } else if (array[slow] == array[fast]) {
                while (fast < array.length && array[slow] == array[fast]) {
                    fast++;
                }
                fast--;
                slow--;
            }
        }
        return Arrays.copyOf(array, slow + 1);
    }
}
