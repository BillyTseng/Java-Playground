package leet.kSum;

import java.util.ArrayList;
import java.util.List;

public class Q653_TwoSumIV_InputBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    private void inOrder(TreeNode head, List<Integer> list) {
        if (head == null) {
            return;
        }

        inOrder(head.left, list);
        list.add(head.val);
        inOrder(head.right, list);
    }
}
