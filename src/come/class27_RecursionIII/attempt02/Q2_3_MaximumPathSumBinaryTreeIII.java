package come.class27_RecursionIII.attempt02;

public class Q2_3_MaximumPathSumBinaryTreeIII {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[] {Integer.MIN_VALUE};
        maxPathSum(root, 0, max);
        return max[0];
    }

    private void maxPathSum(TreeNode root, int sum, int[] max) {
        if (root == null) {
            return;
        }

        if (sum < 0) {
            sum = root.key;
        } else {
            sum += root.key;
        }
        max[0] = Math.max(max[0], sum);
        maxPathSum(root.left, sum, max);
        maxPathSum(root.right, sum, max);
    }
}
