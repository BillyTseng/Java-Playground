package leet.topics.kSum;

import java.util.*;

public class Lai182_2SumAllPairII {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // key: array element, value: count of array element
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int num : array) {
            Integer cnt = map.get(num);
            if (target == num + num && cnt != null && cnt == 1) {
                res.add(Arrays.asList(num, num));
            } else if (cnt == null && map.containsKey(target - num)) {
                res.add(Arrays.asList(target - num, num));
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return res;
    }
}
