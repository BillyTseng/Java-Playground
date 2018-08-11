package come.eClass11_mock;

/**
 * 865. Smallest Subtree with all the Deepest Nodes - medium
 */

public class Q1_SmallestSubtreeWithDeepestNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }

    /**
     * node: current node.
     * depth: the depth from the current node to the deepest leaf.
     */
    class Result {
        TreeNode node;
        int depth;

        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    private Result dfs(TreeNode node) {
        if (node == null) {
            return new Result(null, 0);
        }

        Result left = dfs(node.left), right = dfs(node.right);
        if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        } else if (left.depth < right.depth) {
            return new Result(right.node, right.depth + 1);
        } else {
            return new Result(node, left.depth + 1);
        }
    }
}
