package come.class09_StringII.attempt02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutationsII {
    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        helper(set.toCharArray(), res, 0);
        return res;
    }

    private void helper(char[] chars, List<String> res, int idx) {
        if (idx == chars.length) {
            res.add(new String(chars));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = idx; i < chars.length; i++) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                swap(chars, i, idx);
                helper(chars, res, idx + 1);
                swap(chars, i, idx);
            }
        }
    }

    private void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
