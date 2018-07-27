package come.eClass4_tree;

public class Q5_BinaryTreeLongestConsecutiveSequence {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public int longestConsecutive(TreeNode root) {
        int[] max = new int[] {0};
        dfs(root, max);
        return max[0];
    }

    private int dfs(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int cur = 1;
        int left = dfs(root.left, max);
        int right = dfs(root.right, max);
        if (root.left != null && root.key + 1 == root.left.key) {
            cur = Math.max(cur, left + 1);
        }

        if (root.right != null && root.key + 1 == root.right.key) {
            cur = Math.max(cur, right + 1);
        }
        max[0] = Math.max(max[0], cur);
        return cur;
    }
}
