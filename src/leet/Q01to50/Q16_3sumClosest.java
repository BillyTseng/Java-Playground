package leet.Q01to50;

import java.util.Arrays;

public class Q16_3sumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int k = 0; k < nums.length - 2; k++) {
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
                if (Math.abs(target - sum) < diff) {
                    diff = Math.abs(target - sum);
                    ans = sum;
                }
            }
        }
        return ans;
    }
}
