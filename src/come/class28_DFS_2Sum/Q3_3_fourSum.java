package come.class28_DFS_2Sum;

import java.util.HashMap;
import java.util.Map;

public class Q3_3_fourSum {
    class Pair {
        int left;
        int right;
        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public boolean exist(int[] array, int target) {
        Map<Integer, Pair> map = new HashMap<>();
        for (int j = 1; j < array.length; j++) {
            for (int i = 0; i < j; i++) {
                int pairSum = array[i] + array[j];
                if (map.containsKey(target - pairSum) && map.get(target - pairSum).right < i) {
                    return true;
                }
                if (!map.containsKey(pairSum)) {
                    map.put(pairSum, new Pair(i, j));
                }
            }
        }
        return false;
    }
}
