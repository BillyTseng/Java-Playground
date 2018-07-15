package come.class28_DFS_2Sum.attempt02;

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
        permutations(cArray, res, 0);
        return res;
    }

    private void permutations(char[] cArray, List<String> res, int idx) {
        if (idx == cArray.length) {
            res.add(new String(cArray));
        }

        Set<Character> visited = new HashSet<>();
        for (int i = idx; i < cArray.length; i++) {
            if (visited.add(cArray[i])) {
                swap(cArray, i, idx);
                permutations(cArray, res, idx + 1);
                swap(cArray, i, idx);
            }
        }
    }

    private void swap(char[] input, int a, int b) {
        char temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
