package leet.Q01to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Q15_3sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);

        for (int k = 0; k < nums.length - 2; k++) {
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
