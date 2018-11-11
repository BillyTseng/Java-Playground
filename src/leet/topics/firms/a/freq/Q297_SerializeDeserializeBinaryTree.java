package leet.topics.firms.a.freq;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Q297_SerializeDeserializeBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {
        private final String DELIMITER = ",";
        private final String NULL_NODE = "#";
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preOrder(root, sb);
            return sb.toString();
        }

        private void preOrder(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL_NODE).append(DELIMITER);
            } else {
                sb.append(root.val).append(DELIMITER);
                preOrder(root.left, sb);
                preOrder(root.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            String[] strs = data.split(DELIMITER);
            Queue<String> queue = new ArrayDeque<>(Arrays.asList(strs));
            return buildTree(queue);
        }

        private TreeNode buildTree(Queue<String> queue) {
            if (queue.isEmpty()) {
                return null;
            }
            String polledStr = queue.poll();
            if (polledStr.equals(NULL_NODE)) {
                return null;
            }

            TreeNode head = new TreeNode(Integer.valueOf(polledStr));

            head.left = buildTree(queue);
            head.right = buildTree(queue);

            return head;
        }
    }
}
