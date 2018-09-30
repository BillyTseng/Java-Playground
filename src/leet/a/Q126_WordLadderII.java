package leet.a;

import java.util.*;

public class Q126_WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Map<String, Integer> distance = new HashMap<>();
        Map<String, List<String>> adj = new HashMap<>();

        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dict.add(beginWord);
        bfs(beginWord, endWord, dict, distance, adj);

        path.add(beginWord);
        dfs(beginWord, endWord, path, res, dict, distance, adj);
        return res;
    }

    private void dfs(String beginWord,
                     String endWord,
                     List<String> path,
                     List<List<String>> res,
                     Set<String> dict,
                     Map<String, Integer> distance,
                     Map<String, List<String>> adj) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (String nei : adj.get(beginWord)) {
            path.add(nei);
            if (dict.contains(nei) && distance.get(beginWord) + 1 == distance.get(nei)) {
                dfs(nei, endWord, path, res, dict, distance, adj);
            }
            path.remove(path.size() - 1);
        }
    }

    private void bfs(String beginWord,
                     String endWord,
                     Set<String> dict,
                     Map<String, Integer> distance,
                     Map<String, List<String>> adj) {
        for (String word : dict) {
            adj.put(word, new ArrayList<>());
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);

        distance.put(beginWord, 0);
        while (!queue.isEmpty()) {
            String currWord = queue.poll();
            int level = distance.get(currWord);

            List<String> neighbors = getNeighbors(currWord, dict);
            for (String nei : neighbors) {
                adj.get(currWord).add(nei);
                if (!distance.containsKey(nei)) {
                    distance.put(nei, level + 1);
                    if (!endWord.equals(nei)) {
                        queue.offer(nei);
                    }
                }
            }
        }
    }

    private List<String> getNeighbors(String input, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] charArr = input.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] == ch) {
                    continue;
                }

                char backup = charArr[i];
                charArr[i] = ch;
                if (dict.contains(String.valueOf(charArr))) {
                    res.add(String.valueOf(charArr));
                }
                charArr[i] = backup;
            }
        }
        return res;
    }
}
