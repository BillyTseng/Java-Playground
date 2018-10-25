package come.planS.array_string;

import java.util.*;

public class TwoSumAllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // key: array element, value: indices
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target - array[i])) {
                for (int idx : map.get(target - array[i])) {
                    res.add(Arrays.asList(idx, i));
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
