package come.class15_DP2.attempt02;

public class LargestSubArraySum {
    public int largestSum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];
        int prevSum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (prevSum < 0) {
                prevSum = array[i];
            } else {
                prevSum += array[i];
            }
            max = Math.max(max, prevSum);
        }
        return max;
    }
}
