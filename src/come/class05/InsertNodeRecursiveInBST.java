package come.class05;

public class InsertNodeRecursiveInBST {
    private TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (key < root.key) {
            return insert(root.left, key);
        } else if (root.key > key) {
            return insert(root.right, key);
        } else {
            return root;
        }
    }
}
