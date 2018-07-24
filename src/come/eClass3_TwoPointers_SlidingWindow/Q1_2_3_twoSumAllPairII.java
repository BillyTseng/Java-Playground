package come.eClass3_TwoPointers_SlidingWindow;

import java.util.*;

public class Q1_2_3_twoSumAllPairII {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : array) {
            Integer freqCnt = map.get(num);
            if (num * 2 == target && freqCnt != null && freqCnt == 1) {
	            res.add(Arrays.asList(num, num));
            } else if (freqCnt == null && map.containsKey(target - num)) {
                res.add(Arrays.asList(target - num, num));
            }

            if (freqCnt == null) {
                map.put(num, 1);
            } else {
                map.put(num, freqCnt + 1);
            }
        }
        return res;
    }
}
