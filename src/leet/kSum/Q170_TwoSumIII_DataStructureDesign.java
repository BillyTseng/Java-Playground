package leet.kSum;

import java.util.HashMap;
import java.util.Map;

public class Q170_TwoSumIII_DataStructureDesign {
    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    public Q170_TwoSumIII_DataStructureDesign() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int num : map.keySet()) {
            int target = value - num;
            if (map.containsKey(target)) {
                if (target == num && map.get(num) < 2) {
                    continue;
                }
                return true;
            }
        }
        return false;
    }
}
