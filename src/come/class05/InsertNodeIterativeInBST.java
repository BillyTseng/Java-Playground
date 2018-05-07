package come.class05;

public class InsertNodeIterativeInBST {
    public TreeNode insert(TreeNode root, int key) {
        TreeNode newNode = new TreeNode(key);
        if (root == null) {
            return newNode;
        }

        TreeNode curr = root;
        while (curr != null && curr.key != key) {
            if (key < curr.key) {
                if (curr.left == null) {
                    curr.left = newNode;
                    break;
                } else {
                    curr= curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right= newNode;
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
        return root;
    }
}
