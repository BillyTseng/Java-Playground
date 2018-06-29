package come.class05_BinaryTree_BinarySearchTree.etc;

import come.class05_BinaryTree_BinarySearchTree.TreeNode;

public class DeleteInBinarySearchTree {
    private TreeNode delete(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.key) {
            root.left = delete(root.left, key);
            return root;
        } else if (root.key < key) {
            root.right = delete(root.right, key);
            return root;
        }

        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }

        if (root.right.left == null) {
            root.right.left = root.left;
            return root.right;
        }

        TreeNode smallest = deleteSmallest(root.right);
        smallest.left = root.left;
        smallest.right = root.right;
        return smallest;
    }

    private TreeNode deleteSmallest(TreeNode curr) {
        TreeNode prev = curr;
        curr = curr.left;
        while (curr != null && curr.left != null) {
            prev = curr;
            curr = curr.left;
        }
        prev.left = prev.left.right;
        return curr;
    }
}
