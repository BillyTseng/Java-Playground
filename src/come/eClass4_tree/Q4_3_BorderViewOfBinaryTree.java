package come.eClass4_tree;

import java.util.ArrayList;
import java.util.List;

public class Q4_3_BorderViewOfBinaryTree {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public List<Integer> borderView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.key);

        leftBound(root.left, res);
        leaves(root.left, res);
        leaves(root.right, res);
        rightBound(root.right, res);
        return res;
    }

    private void leaves(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(root.key);
            return;
        }
        leaves(root.left, res);
        leaves(root.right, res);
    }

    private void leftBound(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        res.add(root.key);
        if (root.left != null) {
            leftBound(root.left, res);
        }
    }

    private void rightBound(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if (root.right != null) {
            rightBound(root.right, res);
        }
        res.add(root.key);
    }
}
