package come.eClass8_DP;

/**
 * 213. House Robber II - medium
 */

public class Q2_2_HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    private int robHelper(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }

        int prevPrev = nums[i];
        int prev = Math.max(nums[i], nums[i + 1]);
        for (int k = i + 2; k <= j; k++) {
            int cur = Math.max(prevPrev + nums[k], prev);
            prevPrev = prev;
            prev = cur;
        }
        return prev;
    }
}
