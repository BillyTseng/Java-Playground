package come.class07_GraphII_DFS;

import java.util.ArrayList;
import java.util.List;

public class Q4_AllPermutationsI {
    public List<String> permutations(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] setArray = set.toCharArray();
        helper(setArray, res, 0);
        return res;
    }

    private void helper(char[] setArray, List<String> res, int index) {
        if (index == setArray.length) {
            StringBuilder sb = new StringBuilder();
            for (char c : setArray) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }
        for (int i = index; i < setArray.length; i++) {
            swap(setArray, index, i);
            helper(setArray, res, index + 1);
            swap(setArray, index, i);
        }
    }

    private void swap(char[] array, int a, int b) {
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
