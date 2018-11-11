package leet.topics.firms.a;

import java.util.TreeSet;

// Time complexity: O(nlog(min(n,k))), Space complexity: O(min(n,k))

public class Q220_ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && (Long.valueOf(ceiling) - (long)nums[i]) <= t) {
                return true;
            }

            Integer floor = set.floor(nums[i]);
            if (floor != null && ((long)nums[i] - Long.valueOf(floor)) <= t) {
                return true;
            }

            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
