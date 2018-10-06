package leet.kSum;

import java.util.*;

public class Lai181_2SumAllPairI {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // key: array element, value: list of array element's index
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> indices = map.get(target - array[i]);
            if (indices != null) {
                for (int idx : indices) {
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
