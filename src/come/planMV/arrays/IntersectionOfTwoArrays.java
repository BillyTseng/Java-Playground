package come.planMV.arrays;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/intersection-of-two-arrays/ easy */

public class IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums2) {
            if (map1.containsKey(num)) {
                map2.put(num, map2.getOrDefault(num, 0) + 1);
            }
        }
        int arrayLength = 0;
        for (Map.Entry<Integer, Integer> e : map2.entrySet()) {
            arrayLength += e.getValue();
        }
        int[] res = new int[arrayLength];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : map2.entrySet()) {
            Integer count = e.getValue();
            while (count-- > 0) {
                res[i++] = e.getKey();
            }
        }
        return res;
    }
}
