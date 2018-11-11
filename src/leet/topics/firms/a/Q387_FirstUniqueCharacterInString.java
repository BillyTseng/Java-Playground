package leet.topics.firms.a;

import java.util.HashMap;
import java.util.Map;

public class Q387_FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        // key: character, value: frequency
        Map<Character, Integer> freqMap = buildFreqMap(s);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freqMap.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }

    private Map<Character, Integer> buildFreqMap(String input) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        return freqMap;
    }
}
