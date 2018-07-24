package come.eClass3_TwoPointers_SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1_2_1_twoSum {
    // two pointers in opposite directions.
    public boolean existSum(int[] array, int target) {
        // simulate a sorted array.
        Arrays.sort(array);

        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    // hashset
    public boolean existSumI(int[] array, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(target - num);
            }
        }
        return false;
    }
}
