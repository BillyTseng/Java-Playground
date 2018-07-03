package come.class27_RecursionIII;

import java.util.HashSet;
import java.util.Set;

public class Q2_2_BinaryTreePathSumToTargetIII {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public boolean exist(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        Set<Integer> prefixSumSet = new HashSet<>();
        prefixSumSet.add(0);
        return exist(root, target, 0, prefixSumSet);
    }

    private boolean exist(TreeNode root, int target, int prevSum, Set<Integer> prefixSumSet) {
        prevSum += root.key;
        if (prefixSumSet.contains(prevSum - target)) {
            return true;
        }
        boolean needRemove = prefixSumSet.add(prevSum);
        if (root.left != null && exist(root.left, target, prevSum, prefixSumSet)) {
            return true;
        }
        if (root.right != null && exist(root.right, target, prevSum, prefixSumSet)) {
            return true;
        }
        if (needRemove) {
            prefixSumSet.remove(prevSum);
        }
        return false;
    }
}
