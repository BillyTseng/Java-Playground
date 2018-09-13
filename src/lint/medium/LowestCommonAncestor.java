package lint.medium;

public class LowestCommonAncestor {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A Node in a Binary.
     * @param B: A Node in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || root == A || root == B) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, A, B);
        TreeNode rightNode = lowestCommonAncestor(root.right, A, B);

        if (leftNode != null && rightNode != null) {
            return root;
        }

        if (leftNode != null) {
            return leftNode;
        }
        if (rightNode != null) {
            return rightNode;
        }
        return null;
    }
}
