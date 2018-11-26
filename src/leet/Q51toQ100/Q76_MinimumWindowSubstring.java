package leet.Q51toQ100;

import java.util.HashMap;
import java.util.Map;

public class Q76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // corner case
        if (s.length() < t.length()) {
            return "";
        }
        // build target string's hashmap
        Map<Character, Integer> tMap = buildTMap(t);
        int start = 0, wordCount = 0, minLength = Integer.MAX_VALUE, index = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer count = tMap.get(ch);
            if (count != null) {
                tMap.put(ch, count - 1);
                if (count == 1) {
                    wordCount++;
                }
            }

            while (wordCount == tMap.size()) {
                if (minLength > i - start + 1) {
                    minLength = i - start + 1;
                    index = start;
                }

                char leftMostCh = s.charAt(start++);
                Integer leftMostCount = tMap.get(leftMostCh);
                if (leftMostCount != null) {
                    tMap.put(leftMostCh, leftMostCount + 1);
                    if (leftMostCount == 0) {
                        wordCount--;
                    }
                }
            }
        }
        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(index, index + minLength);
    }

    private Map<Character, Integer> buildTMap(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map;
    }
}
