package come.class08_HashTable_StringI.attempt02;

import java.util.ArrayList;
import java.util.List;

public class CommonNumbersOfTwoSortedArrays {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        while (i < A.size() && j < B.size()) {
            if (A.get(i) < B.get(j)) {
                i++;
            } else if (A.get(i) > B.get(j)) {
                j++;
            } else {
                res.add(A.get(i));
                i++;
                j++;
            }
        }
        return res;
    }
}
