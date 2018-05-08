package come.class04.binarytree;

public class SearchNodeRecursiveInBST {
    private TreeNode search(TreeNode root, int target) {
        if (root == null || root.key == target) {
            return root;
        } else if (root.key < target) {
            return search(root.right, target);
        } else {
            return search(root.left, target);
        }
    }
}
