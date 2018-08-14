package come.Freq;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring - hard
 */

public class Q2_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // assume s and t are not null
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> wordDict = buildWordDict(t);
        int slow = 0, minLength = Integer.MAX_VALUE, index = 0, wordCount = 0;

        for (int fast = 0; fast < s.length(); fast++) {
            char ch = s.charAt(fast);
            Integer count = wordDict.get(ch);
            if (count == null) {
                continue;
            }
            wordDict.put(ch, count - 1);
            if (count == 1) {
                // 1->0
                wordCount++;
            }

            while (wordCount == wordDict.size()) {
                // find a valid string.
                if (fast - slow + 1 < minLength) {
                    index = slow;
                    minLength = fast - slow + 1;
                }
                char leftMostCh = s.charAt(slow++);
                Integer leftMostCount = wordDict.get(leftMostCh);
                if (leftMostCount == null) {
                    continue;
                }
                wordDict.put(leftMostCh, leftMostCount + 1);
                if (leftMostCount == 0) {
                    // 0->1
                    wordCount--;
                }
            }
        }
        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(index, index + minLength);
    }

    private Map<Character, Integer> buildWordDict(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            // Integer count = map.get(ch);
            // if (count == null) {
            //     map.put(ch, 1);
            // } else {
            //     map.put(ch, count + 1);
            // }
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}
