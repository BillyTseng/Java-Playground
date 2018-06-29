package come.class04_Linked_List.attempt02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostOrderTraversalOfBinaryTree {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peekFirst();
            if (prev == null || curr == prev.left || curr == prev.right) {
                if (curr.left != null) {
                    stack.offerFirst(curr.left);
                } else if (curr.right != null) {
                    stack.offerFirst(curr.right);
                } else {
                    res.add(curr.key);
                    stack.pollFirst();
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.offerFirst(curr.right);
                } else {
                    res.add(curr.key);
                    stack.pollFirst();
                }
            } else {
                res.add(curr.key);
                stack.pollFirst();
            }
            prev = curr;
        }
        return res;
    }
}
