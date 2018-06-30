package come.class14_DP1;

public class Q1_LongestAscendingSubArray {
    public int longestI(int[] array) {
        // space: O(n)
        if (array.length == 0) {
            return 0;
        }

        int[] lengths = new int[array.length];
        lengths[0] = 1;
        int max = 1;
        for (int i = 1; i < lengths.length; i++) {
            if (array[i - 1] < array[i]) {
                lengths[i] = lengths[i - 1] + 1;
                max = Math.max(max, lengths[i]);
            } else {
                lengths[i] = 1;
            }
        }
        return max;
    }

    public int longestII(int[] array) {
        // space: O(1)
        if (array.length == 0) {
            return 0;
        }
        int cur = 1;
        int res = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i]) {
                cur++;
                res = Math.max(res, cur);
            } else {
                cur = 1;
            }
        }
        return res;
    }
}
