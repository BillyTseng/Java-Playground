package come.eClass3_TwoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1_2_4_threeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int twoSum = array[left] + array[right];
                if (twoSum + array[i] == target) {
                    res.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }
                } else if (twoSum + array[i] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
