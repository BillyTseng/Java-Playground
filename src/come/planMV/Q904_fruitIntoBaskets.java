package come.planMV;

import java.util.HashMap;
import java.util.Map;

public class Q904_fruitIntoBaskets {
    // time: O(n), space: O(1)
    public int totalFruit(int[] tree) {
        // key: type of fruit, value: count
        Map<Integer, Integer> window = new HashMap<>();

        int slow = 0, maxAmount = 0;
        for (int fast = 0; fast < tree.length; fast++) {
            int fruit = tree[fast];
            window.put(fruit, window.getOrDefault(fruit, 0) + 1);
            while (window.size() > 2) {
                Integer count = window.get(tree[slow]);
                if (count > 1) {
                    window.put(tree[slow], count - 1);
                } else {
                    window.remove(tree[slow]);
                }
                slow++;
            }
            maxAmount = Math.max(maxAmount, fast - slow + 1);
        }
        return maxAmount;
    }
}
