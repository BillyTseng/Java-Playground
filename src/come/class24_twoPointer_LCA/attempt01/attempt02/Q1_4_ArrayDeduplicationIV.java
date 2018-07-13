package come.class24_twoPointer_LCA.attempt01.attempt02;

import java.util.Arrays;

public class Q1_4_ArrayDeduplicationIV {
    public int[] dedup(int[] input) {
        int slow = -1;
        for (int fast = 0; fast < input.length; fast++) {
            if (slow == - 1 || input[slow] != input[fast]) {
                input[++slow] = input[fast];
            } else {
                while (fast + 1 < input.length && input[fast + 1] == input[slow]) {
                    fast++;
                }
                slow--;
            }
        }
        return Arrays.copyOf(input, slow + 1);
    }
}
