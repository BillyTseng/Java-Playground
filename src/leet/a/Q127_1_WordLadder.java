package leet.a;

import java.util.*;

// Only return one shortest path.
public class Q127_1_WordLadder {
    public List<String> ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<String> res = new ArrayList<>();
        if (!dict.contains(endWord)) {
            return res;
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        res.add(beginWord);
        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean onlyOneStrPerLevel = true;
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
                            res.add(endWord);
                            return res;
                        }

                        if (dict.contains(newStr)) {
                            dict.remove(newStr);
                            queue.offer(newStr);
                            if (onlyOneStrPerLevel && diffOneChar(newStr, res.get(res.size() - 1))) {
                                onlyOneStrPerLevel = false;
                                res.add(newStr);
                            }
                        }
                    }
                    currCharArr[i] = backup;
                }
            }
        }
        return new ArrayList<>();
    }

    private boolean diffOneChar(String one, String two) {
        int numOfDiff = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) != two.charAt(i)) {
                numOfDiff++;
            }
        }
        return numOfDiff == 1;
    }

    public static void main(String[] args) {
        Q127_1_WordLadder solution = new Q127_1_WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = new String[]{"hot","dot","dog","lot","log","cog"};
        System.out.println(solution.ladderLength(beginWord, endWord, Arrays.asList(wordList)));

        String beginWord1 = "hit";
        String endWord1 = "cog";
        String[] wordList1 = new String[] {"hot","dot","dog","lot","log"};
        System.out.println(solution.ladderLength(beginWord1, endWord1, Arrays.asList(wordList1)));
    }
}
