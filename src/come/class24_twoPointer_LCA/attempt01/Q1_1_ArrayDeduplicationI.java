package come.class24_twoPointer_LCA.attempt01;

import java.util.Arrays;

public class Q1_1_ArrayDeduplicationI {
    public int[] dedup(int[] input) {
        if (input == null || input.length <= 1) {
            return input;
        }
        int slow = 1;
        for (int fast = 1; fast < input.length; fast++) {
            if (input[fast] != input[slow - 1]) {
                input[slow++] = input[fast];
            }
        }
        return Arrays.copyOf(input, slow);
    }
}
