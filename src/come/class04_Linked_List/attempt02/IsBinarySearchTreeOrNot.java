package come.class04_Linked_List.attempt02;

public class IsBinarySearchTreeOrNot {
    public boolean isBST(TreeNode root) {
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
