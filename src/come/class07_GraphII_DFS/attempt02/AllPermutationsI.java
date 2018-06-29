package come.class07_GraphII_DFS.attempt02;

import java.util.ArrayList;
import java.util.List;

public class AllPermutationsI {
    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] array = set.toCharArray();
        helper(array, res, 0);
        return res;
    }

    private void helper(char[] array, List<String> res, int idx) {
        if (idx == array.length) {
            res.add(new String(array));
            return;
        }

        for (int i = idx; i < array.length; i++) {
            swap(array, i, idx);
            helper(array, res, idx + 1);
            swap(array, i, idx);
        }
    }

    private void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
