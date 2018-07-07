package come.class28_DFS_2Sum;

import java.util.*;

public class Q3_1c_twoSumAllPairII {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            Integer count = map.get(num);
            if (num * 2 == target && count != null && count == 1) {
                res.add(Arrays.asList(num, num));
            } else if (map.containsKey(target - num) && count == null) {
                res.add(Arrays.asList(target - num, num));
            }
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }
        return res;
    }
}
