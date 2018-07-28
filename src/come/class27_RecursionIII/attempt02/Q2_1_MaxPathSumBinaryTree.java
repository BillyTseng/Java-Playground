package come.class27_RecursionIII.attempt02;

public class Q2_1_MaxPathSumBinaryTree {
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

    private void maxPathSum(TreeNode root, int[] max, int prefixSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            max[0] = Math.max(prefixSum + root.key, max[0]);
            return;
        }

        maxPathSum(root.left, max, prefixSum + root.key);
        maxPathSum(root.right, max, prefixSum + root.key);
    }
}
