package come.class28_DFS_2Sum;

import java.util.HashSet;
import java.util.Set;

public class Q3_1a_twoSum {
    public boolean existSum(int[] array, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (set.contains(target - num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
