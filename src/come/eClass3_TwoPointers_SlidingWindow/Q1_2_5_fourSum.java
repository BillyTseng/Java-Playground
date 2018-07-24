package come.eClass3_TwoPointers_SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1_2_5_fourSum {
    // time O(n^3), space O(1)
    public boolean exist(int[] array, int target) {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 3; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < array.length - 2; j++) {
                int left = j + 1;
                int right = array.length - 1;
                while (left < right) {
                    int twoSum = array[left] + array[right];
                    if (twoSum + array[i] + array[j] == target) {
                        return true;
                    } else if (twoSum + array[i] + array[j] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return false;
    }

    // time O(n^2), space O(n)
    class Pair {
        int left;
        int right;
        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public boolean existI(int[] array, int target) {
        Arrays.sort(array);
        Map<Integer, Pair> map = new HashMap<>();
        for (int j = 1; j < array.length; j++) {
            for (int i = 0; i < j; i++) {
                int pairSum = array[i] + array[j];
                if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < i) {
                    return true;
                }
                if (!map.containsKey(pairSum)) {
                    map.put(pairSum, new Pair(i, j));
                }
            }
        }
        return false;
    }
}
