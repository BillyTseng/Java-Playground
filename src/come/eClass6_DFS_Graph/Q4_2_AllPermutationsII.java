package come.eClass6_DFS_Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q4_2_AllPermutationsII {
    public List<String> permutations(String input) {
        List<String> res = new ArrayList<>();
        if (input == null) {
            return res;
        }

        permutations(input.toCharArray(), 0, res);
        return res;
    }

    private void permutations(char[] input, int idx, List<String> res) {
        if (idx == input.length) {
            res.add(new String(input));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = idx; i < input.length; i++) {
            if (set.add(input[i])) {
                swap(input, i, idx);
                permutations(input, idx + 1, res);
                swap(input, i, idx);
            }
        }
    }

    private void swap(char[] input, int a, int b) {
        char temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
