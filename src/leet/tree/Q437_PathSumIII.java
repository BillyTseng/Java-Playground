package leet.tree;

import java.util.HashMap;
import java.util.Map;

public class Q437_PathSumIII {
    // time: O(n * h) , space: O(h), h = n^2 or logn
    private int cnt = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        helper(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return cnt;
    }

    private void helper(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum - root.val == 0) {
            cnt++;
        }
        helper(root.left, sum - root.val);
        helper(root.right, sum - root.val);
    }

    // time: O(n), space: O(n)
    public int pathSumI(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return getPathSum(root, sum, 0, map);
    }

    private int getPathSum(TreeNode root, int target, int prefixSum, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        prefixSum += root.val;
        int numPath = map.getOrDefault(prefixSum - target, 0);
        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        int res = numPath + getPathSum(root.left, target, prefixSum, map) + getPathSum(root.right, target, prefixSum, map);
        map.put(prefixSum, map.get(prefixSum) - 1);
        return res;
    }
}
