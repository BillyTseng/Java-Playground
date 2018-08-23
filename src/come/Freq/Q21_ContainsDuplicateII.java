package come.Freq;

import java.util.HashSet;
import java.util.Set;

/**
 * 219. Contains Duplicate II - easy
 */

public class Q21_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> slidingWindow = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!slidingWindow.add(nums[i])) {
                return true;
            }

            if (i >= k) {
                slidingWindow.remove(nums[i - k]);
            }
        }
        return false;
    }
}
