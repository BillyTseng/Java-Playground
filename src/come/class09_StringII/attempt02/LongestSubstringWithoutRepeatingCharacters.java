package come.class09_StringII.attempt02;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        char[] chars = input.toCharArray();
        int write = 0, read = 0, longest = 0;
        while (read < chars.length) {
            if (set.add(chars[read])) {
                read++;
                longest = Math.max(longest, read - write);
            } else {
                set.remove(chars[write++]);
            }
        }
        return longest;
    }
}
