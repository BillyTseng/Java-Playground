package come.class24_twoPointer_LCA.attempt01;

public class Q5_7_LCA_InBinarySearchTree {
    public TreeNode solution(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null) {
            return null;
        }
        if (root.key < one.key && root.key < two.key) {
            return solution(root.right, one, two);
        } else if (root.key > one.key && root.key > two.key) {
            return solution(root.left, one, two);
        } else {
            return root;
        }
    }
}
