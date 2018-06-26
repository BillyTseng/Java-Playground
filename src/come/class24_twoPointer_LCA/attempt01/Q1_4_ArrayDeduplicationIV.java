package come.class24_twoPointer_LCA.attempt01;

import java.util.Arrays;

public class Q1_4_ArrayDeduplicationIV {
    public int[] dedup(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int slow = -1;
        for (int fast = 0; fast < array.length; fast++) {
            if (slow == -1 || array[slow] != array[fast]) {
                array[++slow] = array[fast];
            } else {
                while (fast + 1 < array.length && array[fast + 1] == array[slow]) {
                    fast++;
                }
                slow--;
            }
        }
        return Arrays.copyOf(array, slow + 1);
    }
}
