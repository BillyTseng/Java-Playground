package come.eClass8_DP;

public class Q1_1_LargestSubArraySumOfCircularArray {
    public int largestSum(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }

        int totalSum = findTotalSum(input);

        return Math.max(findLargestSum(input), totalSum - findSmallestSum(input));
    }

    private int findTotalSum(int[] input) {
        int totalSum = 0;
        for (int num : input) {
            totalSum += num;
        }
        return totalSum;
    }

    private int findLargestSum(int[] input) {
        int subLargestSum = input[0];
        int prevSum = input[0];
        for (int i = 1; i < input.length; i++) {
            if (prevSum < 0) {
                prevSum = input[i];
            } else {
                prevSum += input[i];
            }
            subLargestSum = Math.max(subLargestSum, prevSum);
        }
        return subLargestSum;
    }

    private int findSmallestSum(int[] input) {
        int subSmallestSum = input[0];
        int prevSum = input[0];
        for (int i = 1; i < input.length; i++) {
            if (prevSum > 0) {
                prevSum = input[i];
            } else {
                prevSum += input[i];
            }
            subSmallestSum = Math.min(subSmallestSum, prevSum);
        }
        return subSmallestSum;
    }
}
