package leet.topics.tree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Q666_PathSumIV {
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        // key: location of tree node, value: sum of tree node
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(nums[0] / 10);
        for (int num : nums) {
            map.put(num / 10, num % 10);
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int level = curr / 10, pos = curr % 10;
            int left = (level + 1) * 10 + 2 * pos - 1, right = left + 1;

            int currSum = map.get(curr);
            // if no child, and sum to the total result
            if (!map.containsKey(left) && !map.containsKey(right)) {
                res += currSum;
            }
            if (map.containsKey(left)) {
                map.put(left, map.get(left) + currSum);
                queue.offer(left);
            }
            if (map.containsKey(right)) {
                map.put(right, map.get(right) + currSum);
                queue.offer(right);
            }
        }
        return res;
    }
}
