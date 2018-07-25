package come.eClass3_TwoPointers_SlidingWindow.attempt02;

import java.util.HashMap;
import java.util.Map;

public class Q2_2_MaxValuesOfSizeKSlidingWindows {
    public int lengthOfLongestSubstringKDistinct(String input, int k) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        Map<Character, Integer> counts = new HashMap<>();
        int slow = 0;
        int max = 0;
        for (int i = 0; i < input.length(); i++) {
            char curChar = input.charAt(i);
            Integer cnt = counts.get(curChar);
            if (cnt == null) {
                counts.put(curChar, 1);
            } else {
                counts.put(curChar, cnt + 1);
            }

            while (counts.size() > k) {
                char slowChar = input.charAt(slow);
                Integer remainCnt = counts.get(slowChar);
                if (remainCnt != null) {
                    remainCnt--;
                    if (remainCnt == 0) {
                        counts.remove(slowChar);
                    } else {
                        counts.put(slowChar, remainCnt);
                    }
                }
                slow++;
            }
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }
}
