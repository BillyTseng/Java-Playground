package lint.medium;

import java.util.*;

public class WordLadder {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start.equals(end)) {
            return 1;
        }

        if (dict == null || dict.size() == 0) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        HashSet<String> hash = new HashSet<>();
        int length = 1;

        dict.add(start);
        dict.add(end);
        queue.offer(start);
        hash.add(start);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            length++;
            for (int i = 0; i < qSize; i++) {
                String target = queue.poll();
                for (String nextWord : getNextWords(target, dict)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }

                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }

    private String replace(String target, int idx, char character) {
        char[] chars = target.toCharArray();
        chars[idx] = character;
        return new String(chars);
    }

    private List<String> getNextWords(String target, Set<String> dict) {
        List<String> nextWords = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < target.length(); i++) {
                if (c == target.charAt(i)) {
                    continue;
                }
                String nextWord = replace(target, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
}
