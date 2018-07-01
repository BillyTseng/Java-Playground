package come.class21_RecursionII;

public class Q5_2_FindNodeWithMaxDiffInBinaryTree {
    class TreeNode {
        private int key;
        TreeNode left;
        TreeNode right;

        TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode maxDiffNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode[] tarNode = new TreeNode[1];
        int[] diff = new int[1];
        diff[0] = -1;
        maxDiffNode(root, tarNode, diff);
        return tarNode[0];
    }

    private int maxDiffNode(TreeNode root, TreeNode[] tarNode, int[] diff) {
        if (root == null) {
            return 0;
        }

        int leftNums = maxDiffNode(root.left, tarNode, diff);
        int rightNums = maxDiffNode(root.right, tarNode, diff);
        int localDiff = Math.abs(leftNums - rightNums);
        if (localDiff > diff[0]) {
            diff[0] = localDiff;
            tarNode[0] = root;
        }
        return leftNums + rightNums + 1;
    }

}
