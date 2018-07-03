package come.class27_RecursionIII;

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
        maxPathSum(root, max, 0);
        return max[0];
    }

    private void maxPathSum(TreeNode root, int[] max, int sum) {
        if (root == null) {
            return;
        }

        if (sum < 0) {
            sum = root.key;
        } else {
            sum += root.key;
        }
        max[0] = Math.max(max[0], sum);
        maxPathSum(root.left, max, sum);
        maxPathSum(root.right, max, sum);
    }
}
