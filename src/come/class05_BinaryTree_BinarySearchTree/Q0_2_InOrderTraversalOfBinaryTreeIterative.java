package come.class05_BinaryTree_BinarySearchTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q0_2_InOrderTraversalOfBinaryTreeIterative {
    public List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> s = new LinkedList<>();
        TreeNode helper = root;

        while (helper != null || !s.isEmpty()) {
            if (helper != null) {
                s.offerFirst(helper);
                helper = helper.left;
            } else {
                helper = s.pollFirst();
                res.add(helper.key);
                helper = helper.right;
            }
        }
        return res;
    }
}
