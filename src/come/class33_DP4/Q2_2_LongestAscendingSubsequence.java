package come.class33_DP4;

public class Q2_2_LongestAscendingSubsequence {
    public int longest(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] refine = new int[array.length + 1];
        int result = 1;

        refine[0] = 0; // Not necessary, but it is the key to update refine's value.
        refine[1] = array[0];
        for (int i = 1; i < array.length; i++) {
            int k = find(refine, 1, result, array[i]);
            if (k == result) {
                result++;
            }
            refine[k + 1] = array[i];
        }
        return result;
    }

    private int find(int[] input, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (input[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
