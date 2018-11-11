package leet.topics.tree;

import java.util.ArrayList;
import java.util.List;

public class Q113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root, sum, 0, path, res);
        return res;
    }

    private void pathSum(TreeNode root, int sum, int prefixSum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && (prefixSum + root.val) == sum) {
            List<Integer> curr = new ArrayList<>(path);
            curr.add(root.val);
            res.add(curr);
            return;
        }
        path.add(root.val);
        pathSum(root.left, sum, prefixSum + root.val, path, res);
        pathSum(root.right, sum, prefixSum + root.val, path, res);
        path.remove(path.size() - 1);
    }
}
