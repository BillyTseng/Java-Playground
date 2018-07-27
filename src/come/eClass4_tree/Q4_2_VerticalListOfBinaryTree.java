package come.eClass4_tree;

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
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> degree = new LinkedList<>();
        int max = 0, min = 0;

        queue.offer(root);
        degree.offer(0);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int currDegree = degree.poll();

            max = Math.max(max, currDegree);
            min = Math.min(min, currDegree);

            if (!map.containsKey(currDegree)) {
                map.put(currDegree, new ArrayList<>());
            }
            map.get(currDegree).add(curr.key);

            if (curr.left != null) {
                queue.offer(curr.left);
                degree.offer(currDegree - 1);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                degree.offer(currDegree + 1);
            }
        }

        for (int key = min; key <= max; key++) {
            if (map.containsKey(key)) {
                res.add(map.get(key));
            }
        }
        return res;
    }
}
