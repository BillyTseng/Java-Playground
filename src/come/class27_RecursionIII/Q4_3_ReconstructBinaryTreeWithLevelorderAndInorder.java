package come.class27_RecursionIII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q4_3_ReconstructBinaryTreeWithLevelorderAndInorder {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }

        List<Integer> lvlList = new ArrayList<>();
        for (int num : levelOrder) {
            lvlList.add(num);
        }
        return reconstruct(inMap, lvlList);
    }

    private TreeNode reconstruct(Map<Integer, Integer> inMap, List<Integer> lvlList) {
        if (lvlList.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(lvlList.remove(0));
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num : lvlList) {
            if (inMap.get(num) < inMap.get(root.key)) {
                left.add(num);
            } else {
                right.add(num);
            }
        }
        root.left = reconstruct(inMap, left);
        root.right = reconstruct(inMap, right);
        return root;
    }
}
