package come.class26_BST_DP;

public class Q3_4_InsertInBinarySearchTree {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    private TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        if (key == root.key) {
            return root;
        } else if (key < root.key) {
            root.left = insert(root.left, key);
        } else { // key > root.key
            root.right = insert(root.right, key);
        }
        return root;
    }
}
