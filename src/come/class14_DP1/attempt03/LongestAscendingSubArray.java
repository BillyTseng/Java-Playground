package come.class14_DP1.attempt03;

public class LongestAscendingSubArray {
    public int longest(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int prev = 1;
        int maxLength = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i] >  input[i - 1]) {
                prev += 1;
                maxLength = Math.max(maxLength, prev);
            } else {
                prev = 1;
            }
        }
        return maxLength;
    }
}
