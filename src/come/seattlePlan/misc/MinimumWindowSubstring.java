package come.seattlePlan.misc;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String source, String target) {
        // key: target's character, value: char's count
        Map<Character, Integer> countMap = buildMap(target);
        int slow = 0, minLen = Integer.MAX_VALUE, idx = 0, wordCount = 0;

        for (int fast = 0; fast < source.length(); fast++) {
            char rightChar = source.charAt(fast);
            Integer count = countMap.get(rightChar);
            if (count == null) {
                continue;
            }
            countMap.put(rightChar, count - 1);
            if (count == 1) {
                wordCount++;
            }

            while (wordCount == countMap.size()) {
                if (fast - slow + 1 < minLen) {
                    minLen = fast - slow + 1;
                    idx = slow;
                }
                char leftChar = source.charAt(slow++);
                Integer leftMostCount = countMap.get(leftChar);
                if (leftMostCount == null) {
                    continue;
                }
                countMap.put(leftChar, leftMostCount + 1);
                if (leftMostCount == 0) {
                    wordCount--;
                }
            }
        }
        return (minLen == Integer.MAX_VALUE) ? "" : source.substring(idx, idx + minLen);
    }

    private Map<Character, Integer> buildMap(String target) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char ch : target.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }
        return countMap;
    }
}
