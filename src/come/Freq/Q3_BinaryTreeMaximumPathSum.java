package come.Freq;

/**
 * 124. Binary Tree Maximum Path Sum - hard
 */

public class Q3_BinaryTreeMaximumPathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }

    private int maxPathSum(TreeNode root, int[] max) {
        int left = (root.left != null) ? Math.max(maxPathSum(root.left, max), 0) : 0;
        int right = (root.right != null) ? Math.max(maxPathSum(root.right, max), 0) : 0;
        int cur = root.val + left + right;
        max[0] = Math.max(cur, max[0]);
        return root.val + Math.max(left, right);
    }
}
