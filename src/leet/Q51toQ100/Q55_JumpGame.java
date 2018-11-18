package leet.Q51toQ100;

public class Q55_JumpGame {
    // DP, time O(n^2), space O(n)
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] canJump = new boolean[n];
        canJump[n - 1] = true;

        for (int i = n - 1; i >= 0; i--) {
            if (i + nums[i] >= n - 1) {
                canJump[i] = true;
            } else {
                for (int j = 1; j <= nums[i]; j++) {
                    if (canJump[i + j]) {
                        canJump[i] = true;
                        break;
                    }
                }
            }
        }
        return canJump[0];
    }

    // greedy, time O(n), space O(1)
    public boolean canJumpI(int[] nums) {
        int reach = nums[0];
        for(int i = 1; i < nums.length && reach >= i; i++) {
            if(i + nums[i] > reach) {
                reach = i + nums[i];
            }
        }
        return reach >= (nums.length - 1);
    }
}
