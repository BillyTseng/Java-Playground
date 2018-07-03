package come.class27_RecursionIII;

public class Q1_4_MaximumPathSumBinaryTreeII {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[]{Integer.MIN_VALUE};
        maxPathSum(root, max);
        return max[0];
    }

    private int maxPathSum(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int leftSum = maxPathSum(root.left, max);
        int rightSum = maxPathSum(root.right, max);
        leftSum = leftSum < 0 ? 0 : leftSum;
        rightSum = rightSum < 0 ? 0 : rightSum;
        max[0] = Math.max(max[0], leftSum + rightSum + root.key);
        return root.key + Math.max(leftSum, rightSum);
    }
}
