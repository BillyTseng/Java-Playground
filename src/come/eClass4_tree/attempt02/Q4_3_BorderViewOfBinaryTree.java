package come.eClass4_tree.attempt02;

import java.util.ArrayList;
import java.util.List;

public class Q4_3_BorderViewOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        res.add(root.val);
        leftBoundary(root.left, res);
        leaves(root.left, res);
        leaves(root.right, res);
        rightBoundary(root.right, res);
        return res;
    }

    private void leftBoundary(TreeNode node, List<Integer> res) {
        if (node == null || node.left == null && node.right == null) {
            return;
        }

        res.add(node.val);
        if (node.left != null) {
            leftBoundary(node.left, res);
        } else {
            leftBoundary(node.right, res);
        }
    }

    private void leaves(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        leaves(node.left, res);
        leaves(node.right, res);
    }

    private void rightBoundary(TreeNode node, List<Integer> res) {
        if (node == null || node.left == null && node.right == null) {
            return;
        }

        if (node.right != null) {
            rightBoundary(node.right, res);
        } else {
            rightBoundary(node.left, res);
        }
        res.add(node.val);
    }
}
