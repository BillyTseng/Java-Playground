package come.eClass5_BST_Sorting;

public class Q3_3_DeleteInBinarySearchTree {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            } else {
                TreeNode smallest = findSmallest(root.right);
                root.key = smallest.key;
                root.right = delete(root.right, smallest.key);
            }
        }
        return root;
    }

    private TreeNode findSmallest(TreeNode root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }
}
