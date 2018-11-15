package leet;

public class Q45_JumpGameII {
    public int jump(int[] nums) {
        final int UNREACHABLE = -1;
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                dp[i] = UNREACHABLE;
            } else if (i + nums[i] >= nums.length - 1) {
                dp[i] = 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= nums[i]; j++) {
                    if (dp[i + j] != UNREACHABLE) {
                        min = Math.min(min, dp[i + j]);
                    }
                }

                if (min == Integer.MAX_VALUE) {
                    dp[i] = UNREACHABLE;
                } else {
                    dp[i] = min + 1;
                }
            }
        }
        return dp[0];
    }
}
