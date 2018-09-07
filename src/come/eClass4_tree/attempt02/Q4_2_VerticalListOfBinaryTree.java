package come.eClass4_tree.attempt02;

import java.util.*;

public class Q4_2_VerticalListOfBinaryTree {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int key) {
            this.key = key;
        }
    }

    public List<List<Integer>> verticalPrint(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // key: degree, value: list of tree node keys
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> degree = new LinkedList<>();

        queue.offer(root);
        degree.offer(0);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            int currDegree = degree.poll();

            min = Math.min(min, currDegree);
            max = Math.max(max, currDegree);

            if (!map.containsKey(currDegree)) {
                map.put(currDegree, new ArrayList<>());
            }
            map.get(currDegree).add(currNode.key);

            if (currNode.left != null) {
                degree.offer(currDegree - 1);
                queue.offer(currNode.left);
            }

            if (currNode.right != null) {
                degree.offer(currDegree + 1);
                queue.offer(currNode.right);
            }
        }

        for (int i = min; i <= max; i++) {
            if (map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;
    }
}
