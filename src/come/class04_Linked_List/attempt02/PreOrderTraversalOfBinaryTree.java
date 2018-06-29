package come.class04_Linked_List.attempt02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class PreOrderTraversalOfBinaryTree {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pollFirst();
            res.add(curr.key);

            if (curr.right != null) {
                stack.offerFirst(curr.right);
            }
            if (curr.left != null) {
                stack.offerFirst(curr.left);
            }
        }
        return res;
    }
}
