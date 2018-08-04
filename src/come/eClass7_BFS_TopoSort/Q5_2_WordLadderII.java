package come.eClass7_BFS_TopoSort;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/description/
 * 126. Word Ladder II - hard
 */

public class Q5_2_WordLadderII {
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (start.equals(end) || !dict.contains(end)) {
            return res;
        }

        Set<String> visited = new HashSet<>();
        Set<String> curLevel = new HashSet<>();
        Map<String, List<String>> graph = new HashMap<>();
        graph.put(end, new ArrayList<>());
        curLevel.add(start);
        boolean found = false;

        while (!curLevel.isEmpty() && !found) {
            Set<String> nextLevelQueue = new HashSet<>();
            visited.addAll(curLevel);

            for (String str : curLevel) {
                char[] currWordArray = str.toCharArray();
                for (int j = 0; j < currWordArray.length; j++) {
                    char backup = currWordArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (currWordArray[j] == c) {
                            continue;
                        } else {
                            currWordArray[j] = c;
                        }

                        String newString = new String(currWordArray);
                        if (!dict.contains(newString)) {
                            continue;
                        }
                        if (found && !end.equals(newString)) {
                            continue;
                        }
                        if (end.equals(newString)) {
                            found = true;
                            graph.get(end).add(str);
                            continue;
                        }
                        if (!visited.contains(newString)) {
                            nextLevelQueue.add(newString);
                            if (!graph.containsKey(newString)) {
                                List<String> list = new ArrayList<>();
                                list.add(str);
                                graph.put(newString, list);
                            } else {
                                graph.get(newString).add(str);
                            }
                        }
                    }
                    currWordArray[j] = backup;
                }
            }
            curLevel = nextLevelQueue;
        }

        if (found) {
            List<String> path = new ArrayList<>();
            trace(res, graph, path, start, end);
        }
        return res;
    }

    private void trace(List<List<String>> res,
                       Map<String, List<String>> graph, List<String> path, String start, String now) {
        path.add(now);
        if (now.equals(start)) {
            List<String> ans = new ArrayList<>(path);
            Collections.reverse(ans);
            res.add(ans);
            path.remove(path.size() - 1);
            return;
        }

        List<String> cur = graph.get(now);
        for (int i = 0; i < cur.size(); i++) {
            trace(res, graph, path, start, cur.get(i));
        }
        path.remove(path.size() - 1);
    }
}
