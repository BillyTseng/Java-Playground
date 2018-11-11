package leet.topics.firms.a;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q98_ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBSTrecursion(TreeNode root) {
        return isValidBSTrecursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTrecursion(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.val <= min || max <= root.val) {
            return false;
        }
        return isValidBSTrecursion(root.left, min, root.val) && isValidBSTrecursion(root.right, root.val, max);
    }

    public boolean isValidBSTiterative(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root, prev = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            }

            TreeNode target = stack.pollFirst();
            if (prev != null && prev.val >= target.val) {
                return false;
            }
            prev = target;
            curr = target.right;
        }
        return true;
    }
}
