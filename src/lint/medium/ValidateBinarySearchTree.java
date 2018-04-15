package lint.medium;

class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class ValidateBinarySearchTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }

        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (min >= root.val || max <= root.val) {
            return false;
        }

        boolean leftRes = isValidBST(root.left, min, root.val);
        boolean rightRes = isValidBST(root.right, root.val, max);
        return leftRes && rightRes;
    }
}
