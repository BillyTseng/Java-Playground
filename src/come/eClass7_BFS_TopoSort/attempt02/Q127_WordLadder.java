package come.eClass7_BFS_TopoSort.attempt02;

import java.util.*;

public class Q127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                List<String> neighbors = generateNeighbors(curr, dict);
                for (String nei : neighbors) {
                    if (nei.equals(endWord)) {
                        return level + 1;
                    }
                    queue.offer(nei);
                }
            }
        }
        return 0;
    }

    private List<String> generateNeighbors(String beginWord, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] arr = beginWord.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (arr[i] == ch) {
                    continue;
                }
                arr[i] = ch;
                String answer = new String(arr);
                if (dict.contains(answer)) {
                    dict.remove(answer);
                    res.add(answer);
                }
            }
            arr[i] = temp;
        }
        return res;
    }
}
