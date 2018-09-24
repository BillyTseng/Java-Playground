package leet.a;

public class Q167_TwoSumII_InputArraySorted {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            int twoSum = numbers[start] + numbers[end];
            if (twoSum == target) {
                return new int[] {start + 1, end + 1};
            } else if (twoSum < target) {
                start++;
            } else {
                end--;
            }
        }
        return null;
    }
}
