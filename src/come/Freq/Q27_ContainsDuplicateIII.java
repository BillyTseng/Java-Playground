package come.Freq;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 220. Contains Duplicate III - medium
 */

public class Q27_ContainsDuplicateIII {
    // treeset, time O(nlogk), space O(k)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            // the smallest number which is larger than nums[i]
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && Long.valueOf(ceiling) - (long)nums[i] <= t) {
                return true;
            }

            // the largest number which is smaller than nums[i]
            Integer floor = set.floor(nums[i]);
            if (floor != null && (long)nums[i] - Long.valueOf(floor) <= t) {
                return true;
            }

            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    // bucket, time O(n), space O(k)
    public boolean containsNearbyAlmostDuplicateI(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }

        Long diff = (long) t + 1; // in case t is 0
        Map<Long, Integer> bucket = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Long idx = ((long) nums[i] - (long) min) / diff;
            boolean checkLeft = checkDistanceValid(idx - 1, bucket, diff, nums, i);
            boolean checkCurrent = checkDistanceValid(idx, bucket, diff, nums, i);
            boolean checkRight = checkDistanceValid(idx + 1, bucket, diff, nums, i);
            if (checkLeft || checkCurrent || checkRight) {
                return true;
            }
            bucket.put(idx, nums[i]);
            if (i >= k) {
                bucket.remove(((long) nums[i - k] - (long) min) / diff);
            }
        }
        return false;
    }

    private boolean checkDistanceValid(Long idx, Map<Long, Integer> bucket, Long diff, int[] nums, int i) {
        Integer bucketValue = bucket.get(idx);
        return bucketValue != null && Math.abs((long) nums[i] - Long.valueOf(bucketValue)) < diff;
    }
}
