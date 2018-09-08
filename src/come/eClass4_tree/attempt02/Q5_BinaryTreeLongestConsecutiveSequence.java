package come.eClass4_tree.attempt02;

public class Q5_BinaryTreeLongestConsecutiveSequence {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] max = {Integer.MIN_VALUE};
        dfs(root, max, null, 0);
        return max[0];
    }

    private void dfs(TreeNode root, int[] max, Integer prev, int longest) {
        if (root == null) {
            return;
        }
        if (prev != null && prev + 1 == root.val) {
            longest += 1;
        } else {
            longest = 1;
        }

        max[0] = Math.max(max[0], longest);
        dfs(root.left, max, root.val, longest);
        dfs(root.right, max, root.val, longest);
    }
}
