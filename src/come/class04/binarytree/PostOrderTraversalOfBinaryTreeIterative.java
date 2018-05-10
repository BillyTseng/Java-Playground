package come.class04.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PostOrderTraversalOfBinaryTreeIterative {
    public List<Integer> postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> s = new LinkedList<>();
        TreeNode prev = null;
        s.offerFirst(root);
        while (!s.isEmpty()) {
            TreeNode curr = s.peekFirst();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    s.offerFirst(curr.left);
                } else if (curr.right != null) {
                    s.offerFirst(curr.right);
                } else {
                    res.add(curr.key);
                    s.pollFirst();
                }
            } else if (curr.left == prev) { // from left subtree
                if (curr.right != null) {
                    s.offerFirst(curr.right);
                } else {
                    res.add(curr.key);
                    s.pollFirst();
                }
            } else { // from right subtree
                res.add(curr.key);
                s.pollFirst();
            }
            prev = curr;
        }
        return res;
    }
}
