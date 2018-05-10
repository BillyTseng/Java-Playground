package come.class04.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PreOrderTraversalOfBinaryTreeIterative {
    public List<Integer> preOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> s = new LinkedList<>();
        s.offerFirst(root);
        while (!s.isEmpty()) {
            TreeNode curr = s.pollFirst();
            res.add(curr.key);
            if (curr.right != null) {
                s.offerFirst(curr.right);
            }
            if (curr.left != null) {
                s.offerFirst(curr.left);
            }
        }
        return res;
    }
}
