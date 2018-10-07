package leet.tree;

public class Q112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean[] hasSum = new boolean[] {false};
        getPathSum(root, sum, hasSum, 0);
        return hasSum[0];
    }

    private void getPathSum(TreeNode root, int sum, boolean[] hasSum, int prefixSum) {
        if (root == null) {
            return;
        }

        if (!hasSum[0] && root.left == null && root.right == null) {
            hasSum[0] = (sum == prefixSum + root.val);
            return;
        }
        getPathSum(root.left, sum, hasSum, prefixSum + root.val);
        getPathSum(root.right, sum, hasSum, prefixSum + root.val);
    }
}
