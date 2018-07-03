package come.class21_RecursionII;

public class Q5_3_LowestCommonAncestorI {
    class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        int leftTotal;

        TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null || root == one || root == two) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
