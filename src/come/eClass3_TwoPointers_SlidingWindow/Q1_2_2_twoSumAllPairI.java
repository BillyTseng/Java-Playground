package come.eClass3_TwoPointers_SlidingWindow;

import java.util.*;

public class Q1_2_2_twoSumAllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            List<Integer> indices = map.get(target - array[i]);
            if (indices != null) {
                for (int idx : indices) {
                    List<Integer> cur = Arrays.asList(idx, i);
                    res.add(cur);
                }
            }

            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<>());
            }
            map.get(array[i]).add(i);
        }
        return res;
    }
}
