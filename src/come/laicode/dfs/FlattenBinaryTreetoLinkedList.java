package come.laicode.dfs;

public class FlattenBinaryTreetoLinkedList {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode flatten(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left);
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode tail = root.right;
            while (tail.right != null) {
                tail = tail.right;
            }
            tail.right = tempRight;
        }
        dfs(root.right);
    }
}
