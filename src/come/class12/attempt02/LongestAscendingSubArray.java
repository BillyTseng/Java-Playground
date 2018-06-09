package come.class12.attempt02;

public class LongestAscendingSubArray {
    public int longest(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int prevSum = 1;
        int max = 1;
        for (int i = 1; i < input.length; i++) {
            int currSum = prevSum;
            if (input[i - 1] < input[i]) {
                currSum += 1;
            } else {
                currSum = 1;
            }
            prevSum = currSum;
            max = Math.max(max, currSum);
        }
        return max;
    }
}
