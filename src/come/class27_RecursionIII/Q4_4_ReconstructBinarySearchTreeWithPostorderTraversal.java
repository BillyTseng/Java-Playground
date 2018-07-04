package come.class27_RecursionIII;

public class Q4_4_ReconstructBinarySearchTreeWithPostorderTraversal {
    public class TreeNode {
        public int key;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int key) {
            this.key = key;
        }
    }

    public TreeNode reconstruct(int[] post) {
        int[] index = new int[] {post.length - 1};
        return reconstruct(post, index, Integer.MIN_VALUE);
    }

    private TreeNode reconstruct(int[] post, int[] index, int min) {
        if (index[0] < 0 || post[index[0]] <= min) {
            return null;
        }
        TreeNode root = new TreeNode(post[index[0]--]);
        root.right = reconstruct(post, index, root.key);
        root.left = reconstruct(post, index, min);
        return root;
    }
}
