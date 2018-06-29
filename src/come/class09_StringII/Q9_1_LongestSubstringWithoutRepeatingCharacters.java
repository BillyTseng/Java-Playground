package come.class09_StringII;

import java.util.HashSet;
import java.util.Set;

public class Q9_1_LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        if (input == null || input.length() <= 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int slow = 0, fast = 0, longest = 0;
        while (fast < input.length()) {
            if (set.add(input.charAt(fast))) {
                fast++;
                longest = Math.max(longest, fast - slow);
            } else {
                set.remove(input.charAt(slow++));
            }
        }
        return longest;
    }
}
