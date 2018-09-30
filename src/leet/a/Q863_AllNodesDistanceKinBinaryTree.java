package leet.a;

import java.util.*;

public class Q863_AllNodesDistanceKinBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        buildGraph(null, root);
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(target);
        seen.add(target);
        int k = 0;
        while (!queue.isEmpty() && k <= K) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (k == K) {
                    res.add(curr.val);
                }
                for (TreeNode nei : graph.get(curr)) {
                    if (!seen.contains(nei)) {
                        seen.add(nei);
                        queue.offer(nei);
                    }
                }
            }
            k++;
        }
        return res;
    }

    private void buildGraph(TreeNode parent, TreeNode child) {
        if (!graph.containsKey(parent)) {
            graph.put(parent, new ArrayList<>());
        }
        if (!graph.containsKey(child)) {
            graph.put(child, new ArrayList<>());
        }
        if (parent != null) {
            graph.get(child).add(parent);
            graph.get(parent).add(child);
        }
        if (child.left != null) {
            buildGraph(child, child.left);
        }
        if (child.right != null) {
            buildGraph(child, child.right);
        }
    }
}
