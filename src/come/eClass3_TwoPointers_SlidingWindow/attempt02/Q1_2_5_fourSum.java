package come.eClass3_TwoPointers_SlidingWindow.attempt02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1_2_5_fourSum {
    private class Pair {
        int left;
        int right;
        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public boolean exist(int[] array, int target) {
        Arrays.sort(array);
        Map<Integer, Pair> map = new HashMap<>();

        for (int j = 1; j < array.length; j++) {
            for (int i = 0; i < j; i++) {
                int sum = array[i] + array[j];
                if (map.containsKey(target - sum) && map.get(target - sum).right < i) {
                    return true;
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, new Pair(i, j));
                }
            }
        }
        return false;
    }
}
