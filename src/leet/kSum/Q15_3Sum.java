package leet.kSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    i++;
                    while (i < j && nums[i] == nums[i - 1]) {
                        i++;
                    }
                } else if (sum < 0) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return res;
    }
}
