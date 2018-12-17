package leet.topics.firms.g;

import java.util.HashMap;
import java.util.Map;

public class Q904_FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        // key: type of fruit, value: count
        Map<Integer, Integer> window = new HashMap<>();
        int slow = 0, max = 0;
        for (int fast = 0; fast < tree.length; fast++) {
            int fruit = tree[fast];
            window.put(fruit, window.getOrDefault(fruit, 0) + 1);
            while (window.size() > 2) {
                int leftMostFruit = tree[slow];
                Integer leftMostCount = window.get(leftMostFruit);
                if (leftMostCount == 1) {
                    window.remove(leftMostFruit);
                } else {
                    window.put(leftMostFruit, leftMostCount - 1);
                }
                slow++;
            }
            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }
}
