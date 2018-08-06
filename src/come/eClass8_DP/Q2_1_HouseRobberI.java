package come.eClass8_DP;

/**
 * 198. House Robber - easy
 */

public class Q2_1_HouseRobberI {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int prevPrev = nums[0];
        int prev = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int cur = Math.max(prevPrev + nums[i], prev);
            prevPrev = prev;
            prev = cur;
        }
        return prev;
    }
}
