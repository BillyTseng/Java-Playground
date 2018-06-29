package come.class05_BinaryTree_BinarySearchTree.etc;

import come.class05_BinaryTree_BinarySearchTree.TreeNode;

public class InsertNodeRecursiveInBST {
    private TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (root.key < key) {
            root.right = insert(root.right, key);
        }
        return root;
    }
}
