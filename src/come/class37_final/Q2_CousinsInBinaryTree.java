package come.class37_final;

/**
 * Check if two nodes are cousins in a Binary Tree
 * Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are cousins of each other or not.
 * Two nodes are cousins of each other if they are at same level and have different parents.
 * https://code.laioffer.com/ui/#/app/problem/295
 */

public class Q2_CousinsInBinaryTree {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    private boolean isCousin = false;
    public boolean isCousin(TreeNode root, int a, int b) {
        getLevel(root, a, b, 0);
        return isCousin;
    }

    private int getLevel(TreeNode root, int a, int b, int level) {
        if (root == null) {
            return -1;
        }
        if (root.key == a || root.key == b) {
            return level;
        }
        int left = getLevel(root.left, a, b, level + 1);
        int right = getLevel(root.right, a, b, level + 1);
        if (left == right && left > level + 1) {
            isCousin  = true;
        }
        return left > right ? left : right;
    }
}
