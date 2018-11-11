package leet.topics.firms.a;

public class Q235_LowestCommonAncestorBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // time O(height), space O(height)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null) {
            return null;
        }

        if (root.val < one.val && root.val < two.val) {
            return lowestCommonAncestor(root.right, one, two);
        } else if (root.val > one.val && root.val > two.val) {
            return lowestCommonAncestor(root.left, one, two);
        } else {
            return root;
        }
    }
}
