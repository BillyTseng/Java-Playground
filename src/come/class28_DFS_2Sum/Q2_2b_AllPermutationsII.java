package come.class28_DFS_2Sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q2_2b_AllPermutationsII {
    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }

        char[] cArray = set.toCharArray();
        permutations(cArray, 0, res);
        return res;
    }

    private void permutations(char[] cArray, int level, List<String> res) {
        if (level == cArray.length) {
            res.add(new String(cArray));
            return;
        }
        Set<Character> used = new HashSet<>();
        for (int i = level; i < cArray.length; i++) {
            if (used.add(cArray[i])) {
                swap(cArray, i, level);
                permutations(cArray, level + 1, res);
                swap(cArray, i, level);
            }
        }
    }

    private void swap(char[] input, int a, int b) {
        char temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
