package come.eClass7_BFS_TopoSort;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/description/
 * 127. Word Ladder - medium
 */

public class Q5_1_WordLadderI {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                String curWord = queue.poll();
                char[] currWordArray = curWord.toCharArray();
                for (int i = 0; i < beginWord.length(); i++) {
                    char backup = currWordArray[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (currWordArray[i] == c) {
                            continue;
                        } else {
                            currWordArray[i] = c;
                        }
                        String newString = new String(currWordArray);
                        if (endWord.equals(newString)) {
                            return steps + 1;
                        }
                        if (dict.contains(newString)) {
                            dict.remove(newString);
                            queue.offer(newString);
                        }
                    }
                    currWordArray[i] = backup;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        Q5_1_WordLadderI solution = new Q5_1_WordLadderI();
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
        wordList = Arrays.asList("hot","dot","dog","lot","log");
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}
