package come.eClass3_TwoPointers_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Q2_3_LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String input, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        int slow = 0;
        int longest = 0;
        for (int fast = 0; fast < input.length(); fast++) {
            Integer curCount = counts.get(input.charAt(fast));
            if (curCount == null) {
                curCount = 0;
            }
            counts.put(input.charAt(fast), curCount + 1);

            while (counts.size() > k) {
                Integer remainCount = counts.get(input.charAt(slow));
                if (remainCount == 1) {
                    counts.remove(input.charAt(slow));
                } else {
                    counts.put(input.charAt(slow), remainCount - 1);
                }
                slow++;
            }

            longest = Math.max(longest, fast - slow + 1);
        }
        return longest;
    }
}
