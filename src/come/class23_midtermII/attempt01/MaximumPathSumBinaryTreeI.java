package come.class23_midtermII.attempt01;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class MaximumPathSumBinaryTreeI {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }

    private int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        Integer leftSum = maxPathSum(root.left, max);
        Integer rightSum = maxPathSum(root.right, max);

        if (root.left != null && root.right != null) {
            max[0] = Math.max(max[0], leftSum + rightSum + root.key);
            return Math.max(leftSum, rightSum) + root.key;
        }
        return root.left == null ? rightSum + root.key : leftSum + root.key;
    }
}
