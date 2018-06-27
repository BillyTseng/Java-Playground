package come.class24_twoPointer_LCA.attempt01;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q5_3_LowestCommonAncestorIV {
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        Set<TreeNode> set = new HashSet<>(nodes);
        return lowestCommonAncestor(root, set);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, Set<TreeNode> set) {
        if (root == null || set.contains(root)) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, set);
        TreeNode right = lowestCommonAncestor(root.right, set);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
