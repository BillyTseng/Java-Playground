package come.class10.attempt02;

public class FindNodeWithMaxDiffInBinaryTree {
    public TreeNode findMaxDiffNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        int[] max = new int[1];
        max[0] = -1;
        TreeNode[] solNode = new TreeNode[1];
        findMaxDiffNode(root, max, solNode);
        return solNode[0];
    }

    private int findMaxDiffNode(TreeNode root, int[] max, TreeNode[] solNode) {
        if (root == null) {
            return 0;
        }
        int leftNum = findMaxDiffNode(root.left, max, solNode);
        int rightNum = findMaxDiffNode(root.right, max, solNode);

        if (max[0] < Math.abs(leftNum - rightNum)) {
            max[0] = Math.abs(leftNum - rightNum);
            solNode[0] = root;
        }
        return 1 + leftNum + rightNum;
    }
}
