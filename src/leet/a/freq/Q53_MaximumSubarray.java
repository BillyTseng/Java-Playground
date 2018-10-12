package leet.a.freq;

public class Q53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prevSum = nums[0];
        int max = prevSum;
        for (int i = 1; i < nums.length; i++) {
            prevSum = Math.max(prevSum + nums[i], nums[i]);
            max = Math.max(prevSum, max);
        }
        return max;
    }
}
