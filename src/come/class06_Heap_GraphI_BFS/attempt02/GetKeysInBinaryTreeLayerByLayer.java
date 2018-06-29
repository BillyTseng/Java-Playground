package come.class06_Heap_GraphI_BFS.attempt02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int key) {
        this.key = key;
    }
}

public class GetKeysInBinaryTreeLayerByLayer {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> layer = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = queue.poll();
                layer.add(curr.key);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            res.add(layer);
        }
        return res;
    }
}
