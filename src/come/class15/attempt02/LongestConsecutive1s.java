package come.class15.attempt02;

public class LongestConsecutive1s {
    public int longest(int[] input) {
        if (input.length == 0) {
            return 0;
        }
        int prevSum = input[0];
        int max = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i - 1] == 0) {
                prevSum = input[i];
            } else {
                prevSum += input[i];
            }
            max = Math.max(max, prevSum);
        }
        return max;
    }
}
