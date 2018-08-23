package come.Freq;

/**
 * 450. Delete Node in a BST - Medium
 */

public class Q22_DeleteNodeInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            TreeNode smallest = findSmallest(root.right);
            root.val = smallest.val;
            root.right = deleteNode(root.right, smallest.val);
        }
        return root;
    }

    private TreeNode findSmallest(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
