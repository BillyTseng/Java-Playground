package come.class35_Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearchII {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    public String[] findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        TrieNode root = buildDict(words);
        final int rows = board.length;
        final int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                helper(root, board, i, j, sb, res, visited);
            }
        }

        String[] resStrings = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resStrings[i] = res.get(i);
        }
        return  resStrings;
    }

    private void helper(TrieNode root,
                        char[][] board, int x, int y, StringBuilder sb, List<String> res, boolean[][] visited) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
            return;
        }
        char ch = board[x][y];
        root = root.children.get(ch);
        if (root == null) {
            return;
        }
        sb.append(ch);
        if (root.isWord) {
            res.add(sb.toString());
            root.isWord = false;
        }

        visited[x][y] = true;
        for (int[] dir : DIRS) {
            int neiX = x + dir[0];
            int neiY = y + dir[1];
            helper(root, board, neiX, neiY, sb, res, visited);
        }
        visited[x][y] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    private TrieNode buildDict(String[] words) {
        TrieNode root = new TrieNode();
        for (String str : words) {
            insert(root, str);
        }
        return root;
    }

    private boolean search(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return cur.isWord;
    }

    private void insert(TrieNode root, String word) {
        if (search(root, word)) {
            return;
        }
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.children.get(word.charAt(i));
            if (next == null) {
                next = new TrieNode();
                cur.children.put(word.charAt(i), next);
            }
            cur = next;
        }
        cur.isWord = true;
    }
}
