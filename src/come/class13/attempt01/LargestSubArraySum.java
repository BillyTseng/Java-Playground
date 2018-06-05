package come.class13.attempt01;

import java.util.Arrays;

public class LargestSubArraySum {
    private int largestSum(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        int max = array[0];
        int prevSum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (prevSum >= 0) {
                prevSum += array[i];
            } else {
                prevSum = array[i];
            }
            max = Math.max(max, prevSum);
        }
        return max;
    }

    // follow up, return the boundary of solution.
    private int[] largestSumLeftAndRightBound(int[] array) {
        // assume array != null && array.length >= 1
        int left = 0, solLeft = 0, solRight = 0;
        int max = array[0];
        int prevSum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (prevSum >= 0) {
                prevSum += array[i];
            } else {
                left = i;
                prevSum = array[i];
            }
            int temp = max;
            max = Math.max(max, prevSum);
            if (max != temp) {
                solLeft = left;
                solRight = i;
            }
        }
        return new int[] {solLeft, solRight};
    }

    public static void main(String[] args) {
        LargestSubArraySum solution = new LargestSubArraySum();
        System.out.println(solution.largestSum(new int[]{2, -1, 4, -2, 1}));
        System.out.println(solution.largestSum(new int[]{-2, -1, -3}));
        System.out.println(solution.largestSum(new int[]{1, 2, 4, -1, -2, 10, -1}));

        System.out.println(Arrays.toString(solution.largestSumLeftAndRightBound(new int[]{2, -1, 4, -2, 1})));
        System.out.println(Arrays.toString(solution.largestSumLeftAndRightBound(new int[]{-2, -1, -3})));
        System.out.println(Arrays.toString(solution.largestSumLeftAndRightBound(new int[]{1, 2, 4, -1, -2, 10, -1})));
    }
}
