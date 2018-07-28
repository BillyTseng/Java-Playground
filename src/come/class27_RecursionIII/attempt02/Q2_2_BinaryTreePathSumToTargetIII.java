package come.class27_RecursionIII.attempt02;

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
        return findSum(root, target, prefixSumSet, 0);
    }

    private boolean findSum(TreeNode root, int target, Set<Integer> prefixSumSet, int prefixSum) {
        prefixSum += root.key;
        if (prefixSumSet.contains(prefixSum - target)) {
            return true;
        }

        boolean needRemove = prefixSumSet.add(prefixSum);
        if (root.left != null && findSum(root.left, target, prefixSumSet, prefixSum)) {
            return true;
        }
        if (root.right != null && findSum(root.right, target, prefixSumSet, prefixSum)) {
            return true;
        }
        if (needRemove) {
            prefixSumSet.remove(prefixSum);
        }
        return false;
    }
}
