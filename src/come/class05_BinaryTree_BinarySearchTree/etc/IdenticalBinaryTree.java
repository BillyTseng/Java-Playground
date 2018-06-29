package come.class05_BinaryTree_BinarySearchTree.etc;

import come.class05_BinaryTree_BinarySearchTree.TreeNode;

public class IdenticalBinaryTree {
    private boolean isIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        } else {
            return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
        }
    }
}
