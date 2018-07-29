package come.eClass5_BST_Sorting;

public class Q1_IsBinarySearchTreeOrNot {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    // recursion with min and max.
    public boolean IsBinarySearchTree(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.key <= min || root.key >= max) {
            return false;
        }

        return isBST(root.left, min, root.key) && isBST(root.right, root.key, max);
    }

    // In-order traversal
    public boolean isBinarySearchTreeI(TreeNode root) {
        TreeNode[] prev = {null};
        boolean[] result = {true};

        helper(root, prev, result);
        return result[0];
    }

    private void helper(TreeNode root, TreeNode[] prev, boolean[] result) {
        if (root == null || !result[0]) {
            return;
        }

        helper(root.left, prev, result);
        if (prev[0] != null && prev[0].key >= root.key) {
            result[0] = false;
            return;
        }
        prev[0] = root;
        helper(root.right, prev, result);
    }
}
