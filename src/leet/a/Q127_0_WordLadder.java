package leet.a;

import java.util.*;

public class Q127_0_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        int steps = 0;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                String currStr = queue.poll();
                char[] currCharArr = currStr.toCharArray();
                for (int i = 0; i < currCharArr.length; i++) {
                    char backup = currCharArr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (currCharArr[i] == ch) {
                            continue;
                        }
                        currCharArr[i] = ch;
                        String newStr = new String(currCharArr);
                        if (endWord.equals(newStr)) {
                            return steps + 1;
                        }
                        if (dict.contains(newStr)) {
                            dict.remove(newStr);
                            queue.offer(newStr);
                        }
                    }
                    currCharArr[i] = backup;
                }
            }
        }
        return 0;
    }
}
