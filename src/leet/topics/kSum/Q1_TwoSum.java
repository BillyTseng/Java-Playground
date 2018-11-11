package leet.topics.kSum;

import java.util.HashMap;
import java.util.Map;

public class Q1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // key: number, value: index of number
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                res[0] = index;
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
