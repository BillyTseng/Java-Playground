package come.class33_DP4;

public class Q2_1_LongestAscendingSubArray {
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int longest = 1;
        int prevLen = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i]) {
                prevLen += 1;
                longest = Math.max(longest, prevLen);
            } else {
                prevLen = 1;
            }
        }
        return longest;
    }
}
