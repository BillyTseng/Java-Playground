package come.Freq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. Find Duplicate Subtrees - medium
 * Time O(n), extra space O(n)
 */

public class Q23_FindDuplicateSubtrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int nextId;
    private Map<String, Integer> trees;
    private Map<Integer, Integer> count;
    private List<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        nextId = 1;
        trees = new HashMap<>();
        count = new HashMap<>();
        res = new ArrayList<>();
        lookup(root);
        return res;
    }

    private int lookup(TreeNode node) {
        if (node == null) {
            return 0;
        }

        String serial = node.val + ", " + lookup(node.left) + ", " + lookup(node.right);

        /* Old way to get currNodeId
        Integer currNodeId = trees.get(serial);
        if (currNodeId == null) {
            currNodeId = nextId;
            nextId++;
            trees.put(serial, currNodeId);
        } */

        // new way to get currNodeId
        trees.put(serial, trees.getOrDefault(serial, nextId++));
        int currNodeId = trees.get(serial);

        count.put(currNodeId, count.getOrDefault(currNodeId, 0) + 1);
        if (count.get(currNodeId) == 2) {
            res.add(node);
        }
        return currNodeId;
    }
}
