package come.class05_BinaryTree_BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class Q2_2_GetKeysInBinarySearchTreeInGivenRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        getRange(root, min, max, res);
        return res;
    }

    private void getRange(TreeNode root, int min, int max, List<Integer> res) {
        if (root == null) {
            return;
        }

        if (root.key > min) {
            getRange(root.left, min, max, res);
        }

        if (min <= root.key && root.key <= max) {
            res.add(root.key);
        }
        if (root.key < max) {
            getRange(root.right, min, max, res);
        }
    }
}
