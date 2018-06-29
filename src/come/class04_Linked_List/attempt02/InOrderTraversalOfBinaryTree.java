package come.class04_Linked_List.attempt02;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrderTraversalOfBinaryTree {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.offerFirst(curr);
                curr = curr.left;
            } else {
                curr = stack.pollFirst();
                res.add(curr.key);
                curr = curr.right;
            }
        }
        return res;
    }
}
