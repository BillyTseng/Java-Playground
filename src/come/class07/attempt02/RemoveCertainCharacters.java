package come.class07.attempt02;

import java.util.HashSet;
import java.util.Set;

public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        if (input == null || input.length() == 0 || t == null || t.length() == 0) {
            return input;
        }
        Set<Character> tar = getTargetSet(t);
        int i = 0, j = 0;
        char[] chars = input.toCharArray();
        while (j < chars.length) {
            if (tar.contains(chars[j])) {
                j++;
            } else {
                chars[i++] = chars[j++];
            }
        }
        return new String(chars, 0, i);
    }

    private Set<Character> getTargetSet(String t) {
        Set<Character> tar = new HashSet<>();
        for (char c : t.toCharArray()) {
            tar.add(c);
        }
        return tar;
    }
}
