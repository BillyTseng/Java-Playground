package come.Freq;

import java.util.HashMap;
import java.util.Map;

public class Q10_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // key : prefix sum, value : frequency of prefix sum
        Map<Integer, Integer> sum = new HashMap<>();
        sum.put(0, 1);
        int prefixSum = 0, count = 0;

        for (int element : nums) {
            prefixSum += element;
            count += sum.getOrDefault(prefixSum - k, 0);
            sum.put(prefixSum, sum.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
