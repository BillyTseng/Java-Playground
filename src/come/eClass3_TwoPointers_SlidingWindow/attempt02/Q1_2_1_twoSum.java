package come.eClass3_TwoPointers_SlidingWindow.attempt02;

import java.util.HashSet;
import java.util.Set;

public class Q1_2_1_twoSum {
    public boolean existSum(int[] array, int target) {
        // Write your solution here
        Set<Integer> twoSum = new HashSet<>();
        for (int num : array) {
            if (twoSum.contains(target - num)) {
                return true;
            }
            twoSum.add(num);
        }
        return false;
    }
}
