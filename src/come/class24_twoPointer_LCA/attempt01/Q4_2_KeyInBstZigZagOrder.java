package come.class24_twoPointer_LCA.attempt01;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class Q4_2_KeyInBstZigZagOrder {
    public List<Integer> zigZag(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root);
        int cnt = 0;
        while (!deque.isEmpty()) {
            if (cnt % 2 == 0) {
                traverseEven(deque, res);
            } else {
                traverseOdd(deque, res);
            }
            cnt++;
        }
        return res;
    }

    private void traverseEven(Deque<TreeNode> deque, List<Integer> res) {
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            TreeNode curr = deque.pollLast();
            res.add(curr.key);
            if (curr.right != null) {
                deque.offerFirst(curr.right);
            }

            if (curr.left != null) {
                deque.offerFirst(curr.left);
            }
        }
    }

    private void traverseOdd(Deque<TreeNode> deque, List<Integer> res) {
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            TreeNode curr = deque.pollFirst();
            res.add(curr.key);
            if (curr.left != null) {
                deque.offerLast(curr.left);
            }
            if (curr.right != null) {
                deque.offerLast(curr.right);
            }
        }
    }
}
