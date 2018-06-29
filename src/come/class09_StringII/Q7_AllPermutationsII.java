package come.class09_StringII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q7_AllPermutationsII {
    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        helper(set.toCharArray(), res, 0);
        return res;
    }

    private void helper(char[] array, List<String> res, int idx) {
        if (idx == array.length) {
            res.add(new String(array));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = idx; i < array.length; i++) {
            if(!set.contains(array[i])) {
                set.add(array[i]);
                swap(array, i, idx);
                helper(array, res, idx + 1);
                swap(array, i, idx);
            }
        }
    }

    private void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
