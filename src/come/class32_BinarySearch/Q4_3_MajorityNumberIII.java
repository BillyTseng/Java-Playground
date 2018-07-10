package come.class32_BinarySearch;

import java.util.*;

public class Q4_3_MajorityNumberIII {
    public List<Integer> majority(int[] array, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : array) {
            Integer count = cntMap.get(num);
            if (count != null) {
                cntMap.put(num, ++count);
            } else {
                cntMap.put(num, 1);
            }
        }

        for (int num : array) {
            Integer count = cntMap.get(num);
            if (count != null && (k * count) > array.length) {
                res.add(num);
                cntMap.remove(num);
            }
        }
        Collections.sort(res);
        return res;
    }

}
