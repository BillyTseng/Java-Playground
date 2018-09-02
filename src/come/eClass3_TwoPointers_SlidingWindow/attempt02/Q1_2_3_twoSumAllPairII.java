package come.eClass3_TwoPointers_SlidingWindow.attempt02;

import java.util.*;

public class Q1_2_3_twoSumAllPairII {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : array) {
            Integer freq = map.get(num);
            if (num * 2 == target && freq != null && freq == 1) {
                res.add(Arrays.asList(num, num));
            } else if (freq == null && map.containsKey(target - num)) {
                res.add(Arrays.asList(num, target - num));
            }

            if (freq == null) {
                map.put(num, 1);
            } else {
                map.put(num, freq + 1);
            }
        }
        return res;
    }
}
