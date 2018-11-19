package leet.Q51toQ100;

public class Q53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int prevSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prevSum < 0) {
                prevSum = nums[i];
            } else {
                prevSum += nums[i];
            }
            maxSum = Math.max(maxSum, prevSum);
        }
        return maxSum;
    }
}
