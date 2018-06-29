package come.class05_BinaryTree_BinarySearchTree.etc;

import come.class05_BinaryTree_BinarySearchTree.TreeNode;

public class SearchNodeIterativeInBST {
    private TreeNode search(TreeNode root, int target) {
        while (root != null && root.key != target) {
            if (root.key < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }
}
