package come.planMV.Recursion;

import java.util.Deque;
import java.util.LinkedList;

public class IsBinarySearchTreeOrNot {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    // iterative, in-order traverse
    public boolean isBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        pushLeft(root, stack);

        TreeNode leftNode = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollFirst();

            // in-order print root.key
            if (leftNode != null && leftNode.key >= curr.key) {
                return false;
            }
            leftNode = curr;

            curr = curr.right;
            pushLeft(curr, stack);
        }

        return true;
    }

    private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
        while (root != null) {
            stack.offerFirst(root);
            root = root.left;
        }
    }

    // Recursion
    public boolean isBST_I(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.key <= min) {
            return false;
        }
        if (root.key >= max) {
            return false;
        }
        return isBST(root.left, min, (long)root.key) && isBST(root.right, (long)root.key, max);
    }
}
