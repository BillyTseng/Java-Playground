package come.class28_DFS_2Sum;

public class Q1_3_ReverseBinaryTreeUpsideDown {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode reverse(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeNode newRoot = reverse(root.left);
        root.left.right = root.right;
        root.left.left = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
