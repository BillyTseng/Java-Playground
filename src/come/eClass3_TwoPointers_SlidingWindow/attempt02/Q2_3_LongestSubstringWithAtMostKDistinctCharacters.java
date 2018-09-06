package come.eClass3_TwoPointers_SlidingWindow.attempt02;

import java.util.HashMap;
import java.util.Map;

public class Q2_3_LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String input, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int slow = 0, longest = 0;

        for (int fast = 0; fast < input.length(); fast++) {
            // put fast
            char fastChar = input.charAt(fast);
            freqMap.put(fastChar, freqMap.getOrDefault(fastChar, 0) + 1);

            // find slow
            while (freqMap.size() > k) {
                char slowChar = input.charAt(slow);
                Integer removeCnt = freqMap.get(slowChar);
                if (removeCnt == 1) {
                    freqMap.remove(slowChar);
                } else {
                    freqMap.put(slowChar, removeCnt - 1);
                }
                slow++;
            }
            longest = Math.max(longest, fast - slow + 1);
        }
        return longest;
    }
}
