package come.eClass5_BST_Sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  653. Two Sum IV - Input is a BST, easy
 *  https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
 */

public class Q4_TwoSumIVinputIsBst {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            val = key;
        }
    }

    // HashSet, time O(n), space O(n)
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTarget(root, k, set);
    }

    private boolean findTarget(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k, set) || findTarget(root.right, k, set);
    }

    // transfer BST to a sorted array, then two pointers, time O(n), space O(n)
    public boolean findTargetI(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum < k) {
                l++;
            } else if (sum > k) {
                r--;
            } else {
                return true;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
