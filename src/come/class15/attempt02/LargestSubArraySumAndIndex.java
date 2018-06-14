package come.class15.attempt02;

/* https://code.laioffer.com/ui/#/app/problem/489 */

public class LargestSubArraySumAndIndex {
    public int[] largestSum(int[] input) {
        int left = 0, solLeft = 0, solRight = 0;
        int prevSum = input[0];
        int max = input[0];
        for (int i = 1; i < input.length; i++) {
            if (prevSum < 0) {
                prevSum = input[i];
                left = i;
            } else {
                prevSum += input[i];
            }
            int temp = max;
            max = Math.max(max, prevSum);
            if (max != temp) {
                solLeft = left;
                solRight = i;
            }
        }
        return new int[] {max, solLeft, solRight};
    }
}
