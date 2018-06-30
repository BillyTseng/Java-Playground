package come.class17_DP3.attempt03;

public class LargestSubArraySumAndIndex {
    public int[] largestSum(int[] array) {
        int left = 0, solLeft = 0, solRight = 0;
        int prevSum = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (prevSum < 0) {
                prevSum = array[i];
                left = i;
            } else {
                prevSum += array[i];
            }
            int temp = max;
            max = Math.max(max, prevSum);
            if (temp != max) {
                solLeft = left;
                solRight = i;
            }
        }
        return new int[] {max, solLeft, solRight};
    }
}
