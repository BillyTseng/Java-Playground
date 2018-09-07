package come.eClass4_tree.attempt02;

public class Q1_CheckIfBinaryTreeIsBalanced {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return dfsHelper(root) != -1;
    }

    private int dfsHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfsHelper(root.left);
        int right = dfsHelper(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }
}
