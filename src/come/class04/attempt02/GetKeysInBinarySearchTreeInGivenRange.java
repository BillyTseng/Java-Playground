package come.class04.attempt02;

import java.util.ArrayList;
import java.util.List;

public class GetKeysInBinarySearchTreeInGivenRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        helper(root, min, max, res);
        return res;
    }

    private void helper(TreeNode root, int min, int max, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (min < root.key) {
            helper(root.left, min, max, res);
        }
        if (min <= root.key && root.key <= max) {
            res.add(root.key);
        }
        if (root.key < max) {
            helper(root.right, min, max, res);
        }
    }
}
